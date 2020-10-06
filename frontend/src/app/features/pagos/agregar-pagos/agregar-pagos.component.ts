import { Component, OnInit } from '@angular/core';
import {PagoService} from '../pago.service';
import { Pago } from '../pago';
import {  FormGroup,  FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router} from '@angular/router';

@Component({
  selector: 'app-agregar-pagos',
  templateUrl: './agregar-pagos.component.html',
  styleUrls: ['./agregar-pagos.component.scss']
})
export class AgregarPagosComponent implements OnInit {

  public pago: Pago;
  public error:string;
  public pagoForm: FormGroup;

  constructor(private pagoService:PagoService,
    private fb: FormBuilder,
    private router: Router) {
    this.pago= new Pago();
   }

  ngOnInit(): void {
    this.error="";
    this.pagoForm= this.fb.group({
      documento: ['',Validators.required],
      monto: ['',Validators.required],
      estado: null,
    });
  }
  get AgregraPagoFormCtrl() {
    return this.pagoForm.controls;
  }
  OnSubmit(){
    if (this.pagoForm.invalid) {
      return;
    }
   
    this.pago = { 
      documento: this.AgregraPagoFormCtrl.documento.value,
      monto: this.AgregraPagoFormCtrl.monto.value,
      estado: null
     
    }
    console.log(this.pago);
    
    this.pagoService.agregarPago(this.pago).subscribe(data => {
      console.log(data);
     this.gotoHome();
    },
    error=>{
    console.log(error),
      this.error = error.error.mensaje
  }
    );

  }
  gotoHome() {
    this.router.navigate(['']);
  }

}
