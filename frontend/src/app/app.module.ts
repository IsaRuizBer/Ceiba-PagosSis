import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {routing} from './app.routing';


import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HomeComponent } from './features/home/home.component';
import { DatePipe } from '@angular/common';


import { HttpClientModule} from '@angular/common/http';
import { PagoService } from './features/pagos/pago.service';
import { UsuarioService } from './features/usuarios/usuario.service';
import { AgregarPagosComponent } from './features/pagos/agregar-pagos/agregar-pagos.component';
import { ConsultarPagosComponent } from './features/pagos/consultar-pagos/consultar-pagos.component';
import {FormsModule,ReactiveFormsModule } from '@angular/forms';
import { UsuariosComponent } from './features/usuarios/usuarios.component';
import { RegistrarUsuarioComponent } from './features/usuarios/registrar-usuario/registrar-usuario.component';
import { EliminarUsuarioComponent } from './features/usuarios/eliminar-usuario/eliminar-usuario.component';
import { EditarUsuarioComponent } from './features/usuarios/editar-usuario/editar-usuario.component';
import { BuscarUsuarioComponent } from './features/usuarios/buscar-usuario/buscar-usuario.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent, 
    AgregarPagosComponent,
    ConsultarPagosComponent,
    UsuariosComponent,
    RegistrarUsuarioComponent,
    EliminarUsuarioComponent,
    EditarUsuarioComponent,
    BuscarUsuarioComponent,
 
    
    
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    routing
 
  ],
  providers: [PagoService, UsuarioService, DatePipe],
  bootstrap: [AppComponent],
  exports: [ AppComponent ],
  entryComponents: [ AppComponent ]
})
export class AppModule { }
