import { Component, OnInit } from '@angular/core';
import {PagoService} from '../pago.service';
import { Pago } from '../pago';


@Component({
  selector: 'app-consultar-pagos',
  templateUrl: './consultar-pagos.component.html',
  styleUrls: ['./consultar-pagos.component.scss']
})
export class ConsultarPagosComponent implements OnInit {

  public pago:  Pago[]= [];
  constructor(private pagoService: PagoService) { }

  ngOnInit(): void {
    console.log("Estoy AQUI!!!!!");
    this.pagoService.listar()
    .subscribe(
      (data) => { // Success
        this.pago = data;
        console.log(this.pago);
      },
      (error) => {
        console.error(error);
      }
    );     
  }

}
