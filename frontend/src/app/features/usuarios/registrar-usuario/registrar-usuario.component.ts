import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuario';
import {  FormGroup,  FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router} from '@angular/router';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-registrar-usuario',
  templateUrl: './registrar-usuario.component.html',
  styleUrls: ['./registrar-usuario.component.scss']
})
export class RegistrarUsuarioComponent implements OnInit {

  public usuario: Usuario;
  public error:string;
  public usuarioForm: FormGroup;
  public ocultarResultado: boolean;

  constructor(private service:UsuarioService,private fb: FormBuilder,
    private router: Router) {
      this.usuario= new Usuario();
    
     }

  ngOnInit(): void {
    this.error="";
    this.usuarioForm= this.fb.group({
      nombre: ['',Validators.required],
      apellido: ['',Validators.required],
      documento: ['',Validators.required],
      correo: ['',Validators.required]
    });    
  }

  get RegistraUsuarioFormCtrl() {
    return this.usuarioForm.controls;
  }

  OnSubmit(){
    if (this.usuarioForm.invalid) {
      return;
    }
   
    this.usuario = { 
    
      nombre: this.RegistraUsuarioFormCtrl.nombre.value,
      apellido: this.RegistraUsuarioFormCtrl.apellido.value,
      documento: this.RegistraUsuarioFormCtrl.documento.value,
      correo: this.RegistraUsuarioFormCtrl.correo.value,
     
    }
    console.log(this.usuario);
    
    this.service.registrar(this.usuario).subscribe(data => {
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

  cancel() {
    if (window.confirm('¿Esta seguro que desea cancelar el registro?'))
      this.gotoHome();
  }

}
