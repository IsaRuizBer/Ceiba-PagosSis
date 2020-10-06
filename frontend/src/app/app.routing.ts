//importar los modulos dela router de angular
import { ModuleWithProviders}  from '@angular/core';
import {Routes, RouterModule } from '@angular/router';

//importar componentes a los cuales les quiero hacer una pagina exclusiva
import {HomeComponent} from './features/home/home.component';
import { ConsultarPagosComponent } from './features/pagos/consultar-pagos/consultar-pagos.component';
import { AgregarPagosComponent } from './features/pagos/agregar-pagos/agregar-pagos.component';
import { RegistrarUsuarioComponent } from './features/usuarios/registrar-usuario/registrar-usuario.component';
import { EliminarUsuarioComponent } from './features/usuarios/eliminar-usuario/eliminar-usuario.component';
import { EditarUsuarioComponent } from './features/usuarios/editar-usuario/editar-usuario.component';



// array de rutas
const appRoutes: Routes =[
        {path:'', component:HomeComponent},       
        {path:'consultar_pago', component:ConsultarPagosComponent},
        {path:'registrar_pago', component:AgregarPagosComponent},
        {path:'registrar_usuario', component:RegistrarUsuarioComponent},
        {path:'registrar_usuario', component:RegistrarUsuarioComponent},
        {path:'eliminar_usuario', component:EliminarUsuarioComponent},
        {path:'editar_usuario', component:EditarUsuarioComponent},

      
];

//crear el modulo de rutas
export const appRoutingProviders : any[] = [];
export const routing : ModuleWithProviders<any>= RouterModule.forRoot(appRoutes);


