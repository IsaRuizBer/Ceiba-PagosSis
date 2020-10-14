import { Component, OnInit, Output, EventEmitter  } from '@angular/core';
import { Usuario } from '../usuario';
import {  FormGroup,  FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router} from '@angular/router';
import { UsuarioService } from '../usuario.service';



@Component({
  selector: 'app-buscar-usuario',
  templateUrl: './buscar-usuario.component.html',
  styleUrls: ['./buscar-usuario.component.scss']
})
export class BuscarUsuarioComponent implements OnInit {

  public buscarForm: FormGroup;  
  public ocultarResultado: boolean;
  public usuario: Usuario;
  public documento: string;
  public error:string;
  @Output() event = new EventEmitter<string>();


  constructor(private service:UsuarioService,private fb: FormBuilder,
    private router: Router, private formBuilder: FormBuilder) {
      this.usuario= new Usuario();     
   
     }

     ngOnInit(): void {    
      this.buscarForm= this.fb.group({      
        documento: ['',Validators.required]
       
      });  
      
    }

    sendMessage(valor:string) {
      this.event.emit(valor);
      console.log(valor)
     
    }


    get buscarUsuarioFormCtrl(){
      return this.buscarForm.controls;
    }

    gotoEditar() {
      this.router.navigate(['/Editar']);
    }

}
