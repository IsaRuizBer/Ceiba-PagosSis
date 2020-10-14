import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuario';
import {  FormGroup,  FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router} from '@angular/router';
import { UsuarioService } from '../usuario.service';
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-editar-usuario',
  templateUrl: './editar-usuario.component.html',
  styleUrls: ['./editar-usuario.component.scss']
})
export class EditarUsuarioComponent implements OnInit {

  public editarForm: FormGroup;
 // public buscarForm: FormGroup;  
  public error:string;
  public ocultarResultado: boolean;
  public usuario: Usuario;
  public usuarioEdit: Usuario;
  public documento: string;
 

  constructor(private service:UsuarioService,private fb: FormBuilder,
    private router: Router, private formBuilder: FormBuilder) {
      this.usuario= new Usuario();
      this.usuarioEdit= new Usuario();
      this.documento=null  
     }

  ngOnInit(): void {
    this.error="";
    this.ocultarResultado=true;
   
  }
 

  receiveMessage($event) {
    this.documento = $event
    console.log(this.documento);
    this.buscar();   
  }

  buscar(){

    this.service.listar(this.documento).subscribe(
      (data) => { // Success
        this.usuario = data;
        console.log(this.usuario.nombre);
        this.ocultarResultado=false;   
             
        this.editarForm =this.formBuilder.group({ 
            id:this.usuario.id,
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

get EditarUsuarioFormCtrl(){
  return this.editarForm.controls;
}

OnSubmit(){    

  if (this.editarForm.invalid) {
    return;
  }
 
  this.usuarioEdit = { 
    id:this.usuario.id,
    documento: this.EditarUsuarioFormCtrl.documento.value,
    nombre:this.EditarUsuarioFormCtrl.nombre.value,
    apellido:this.EditarUsuarioFormCtrl.apellido.value,   
    correo: this.EditarUsuarioFormCtrl.correo.value   
   
  }

  console.log(this.usuarioEdit),
  
  this.service.editar(this.documento,this.usuarioEdit).subscribe(data => {
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
  if (window.confirm('¿Esta seguro que desea cancelar la eliminación?'))
    this.gotoHome();
}
}
