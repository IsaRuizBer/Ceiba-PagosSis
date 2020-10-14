import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuario';
import {  FormGroup,  FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router} from '@angular/router';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-eliminar-usuario',
  templateUrl: './eliminar-usuario.component.html',
  styleUrls: ['./eliminar-usuario.component.scss']
})
export class EliminarUsuarioComponent implements OnInit {
  
  public eliminarForm: FormGroup;
  public error:string;
  public mensaje:string;
  public ocultarResultado: boolean;
  public usuario: Usuario;
  public documento: string;
  public buscarForm: FormGroup;  

  constructor(private service:UsuarioService,private fb: FormBuilder,
    private router: Router, private formBuilder: FormBuilder) {
      this.usuario= new Usuario();
      this.documento=null    
     }

  ngOnInit(): void {
    this.error="";
    this.mensaje="";
    this.ocultarResultado=true; 
    this.buscarForm= this.fb.group({      
      documento: ['',Validators.required]
     
    }); 

  }



  buscar(){

    this.documento = this.BuscarUsuarioFormCtrl.documento.value;
    this.service.listar(this.documento).subscribe(
      (data) => { // Success
        this.usuario = data;
        console.log(this.usuario.nombre);
        this.ocultarResultado=false;              
        this.eliminarForm =this.formBuilder.group({         
           nombre:this.usuario== null?'': this.usuario.nombre, 
           apellido:  this.usuario== null?'': this.usuario.apellido,
           documento:this.usuario== null?'': this.usuario.documento,
           correo: this.usuario== null?'': this.usuario.correo    
         });
      },
      (error) => {
        console.error(error);
        this.error = error.error.mensaje
      }
    ); 

}
get BuscarUsuarioFormCtrl(){
  return this.buscarForm.controls;
}

  get EliminarUsuarioFormCtrl(){
    return this.eliminarForm.controls;
  }



  OnSubmit(){    
    if (this.eliminarForm.invalid) {
      return;
    }
    
    this.service.eliminar(this.documento).subscribe(data => {
      console.log(data);
      this.mensaje="Eliminación Exitosa";  
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
    if (window.confirm('¿Esta seguro que desea cancelar la eliminación?'))
      this.gotoHome();
  }




}
