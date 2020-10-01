package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionPagoRetrasado;
import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioPago;
import sun.rmi.server.LoaderHandler;


import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class ServicioAgregarPago {

 public static final BigDecimal INCREMENTO= new BigDecimal(20000);

        private final RepositorioPago repositorioPago;

        public ServicioAgregarPago(RepositorioPago repositorioPago) {
            this.repositorioPago = repositorioPago;
        }

        public Pago ejecutar(Pago pago){
            LocalDate fechaPago=obtenerFechaPago(pago.fecha);
            LocalDate fechaTopePago=obtenerFechaTopePago();
            if (fechaPago.isAfter(fechaTopePago)) {
                BigDecimal monto=obtenerMontoIncremento(fechaTopePago,fechaPago, pago.monto);
                throw new ExcepcionPagoRetrasado("Esta realizando un pago fuera de los 5 días hábiles " +
                        "correspondientes a su fecha de pago debe cancelar un incremento de "+monto);
            }

            return repositorioPago.agregar(pago);
        }

        public boolean validaExistencia(Pago pago){
            return repositorioPago.buscarPorFecha(convertToLocalString(pago.fecha),pago.documento);
        }

    public  String convertToLocalString(Date dateToConvert) {
         String fecha=dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().toString();
         return fecha;
    }

    public static LocalDate obtenerFechaPago(Date fecha) {
        LocalDate fechaInicial = LocalDate.now().withDayOfMonth(1);//obtener primer dia del mes
        LocalDate fechaPago=convertToLocalDate(fecha);
        System.out.print(fechaInicial);

            if (validarFinDeSemana(fechaPago)){
                fechaPago.plusDays(2);
            }
       return fechaPago;
    }

    public static LocalDate obtenerFechaTopePago(){
        LocalDate fechaTope = LocalDate.now().withDayOfMonth(1)
                             .plusDays(4);
           return LocalDate.now().plusDays(obtenerDias(LocalDate.now(),fechaTope));
    }

    public static boolean validarFinDeSemana(LocalDate fecha){
        if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || (fecha.getDayOfWeek() == DayOfWeek.SUNDAY))
            return true;
        return false;
    }

    public static Date convertToDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    //se obtienens los dais que hay que sumarle al tope cuando hay fines de semana de por medio
    private static int obtenerDias(LocalDate fechaInic,LocalDate fechaFin) {
        int dias = 0;
        while(!fechaInic.isAfter(fechaFin)) {
           if (validarFinDeSemana(fechaInic))
                dias++;
            fechaInic=fechaInic.plusDays(1);
        }
        return dias;

    }

    public static BigDecimal obtenerMontoIncremento(LocalDate inicio, LocalDate fin, BigDecimal monto){
        long dias = DAYS.between(inicio, fin);
        BigDecimal diasInt=new BigDecimal(Math.toIntExact(dias));
            return diasInt.multiply(INCREMENTO).multiply(monto);
    }
    public static void main(String[] args) {

    }


}
