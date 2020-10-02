package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionPagoRealizado;
import com.ceiba.adn.backend.dominio.excepciones.ExcepcionPagoRetrasado;
import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioPago;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class ServicioAgregarPago {

 public static final BigDecimal INCREMENTO= new BigDecimal(20000);
 public static final String ESTADO_AL_DIA= "Al día";
 public static final String ESTADO_EN_MORA= "En mora";


        private final RepositorioPago repositorioPago;

        public ServicioAgregarPago(RepositorioPago repositorioPago) {
            this.repositorioPago = repositorioPago;
        }

        public Pago ejecutar(Pago pago){
            LocalDate fechaPago=obtenerFechaPago(pago.fecha);
            LocalDate fechaTopePago=obtenerFechaTopePago(LocalDate.now());
            if (validaExistencia(pago))
                throw  new ExcepcionPagoRealizado("Ya existe un pago registrado para el mes en curso");
            if (validarFechaTope(fechaPago,fechaTopePago)) {
                BigDecimal monto=obtenerMontoIncremento(fechaTopePago,fechaPago, pago.monto);
                throw new ExcepcionPagoRetrasado("Esta realizando un pago fuera de los 5 días hábiles " +
                        "correspondientes a su fecha de pago debe cancelar un total de "+monto);
            }
            Pago pagoObj= new Pago(pago.monto,ESTADO_AL_DIA,pago.documento,convertToDate(fechaPago));
            return repositorioPago.agregar(pagoObj);
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

    public  LocalDate obtenerFechaPago(Date fecha) {
        LocalDate fechaPago=convertToLocalDate(fecha);
            if (validarFinDeSemana(fechaPago)){
                return fechaPago.plusDays(2);
            }
       return fechaPago;
    }

    public  LocalDate obtenerFechaTopePago(LocalDate fecha){
        LocalDate fechaTope = fecha.withDayOfMonth(1)
                             .plusDays(4);
           return fechaTope.plusDays(obtenerDias(fecha.withDayOfMonth(1),fechaTope));
    }

    public  boolean validarFinDeSemana(LocalDate fecha){
        return (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || (fecha.getDayOfWeek() == DayOfWeek.SUNDAY));
    }

    public  Date convertToDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public  LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    //se obtienens los dais que hay que sumarle al tope cuando hay fines de semana de por medio
    private  int obtenerDias(LocalDate fechaInic,LocalDate fechaFin) {
        int dias = 0;
        while(!fechaInic.isAfter(fechaFin)) {
           if (validarFinDeSemana(fechaInic))
                dias++;
            fechaInic=fechaInic.plusDays(1);
        }
        return dias;

    }

    public  BigDecimal obtenerMontoIncremento(LocalDate inicio, LocalDate fin, BigDecimal monto){
        long dias = DAYS.between(inicio, fin);
        BigDecimal diasInt=new BigDecimal(Math.toIntExact(dias));
            return diasInt.multiply(INCREMENTO).multiply(monto);
    }

    public  boolean validarFechaTope(LocalDate fechaPago, LocalDate fechaTope){
        return fechaPago.isAfter(fechaTope);
    }


}
