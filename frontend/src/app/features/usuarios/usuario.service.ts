import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from './usuario';
import { environment } from '../../core/environment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private baseEndPoint = environment.endpointBackend;
 // private cabeceras: HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  httpOptions = {
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*',
      'Content-Type':'application/json'
    })
  };

  constructor(protected http: HttpClient) { }


  public listar(documento:String): Observable<Usuario>{
    return this.http.get<Usuario>(this.baseEndPoint+'/pagos/usuarios/buscar/'+documento);
  }


  public registrar(usuario:Usuario){
    console.log("Se registra usuario ");
    return this.http.post<any>(this.baseEndPoint + '/pagos/usuarios/', usuario)
      .pipe(map(res => {
        console.log("Service response : ", res);
        return res;
      }));
  }

  
  public eliminar(documento:String){
    console.log("Se elimina usuario ");
    return this.http.delete<any>(this.baseEndPoint + '/pagos/usuarios/'+ documento)
      .pipe(map(res => {
        console.log("Service response : ", res);
        return res;
      }));
  }

  public editar(documento:String,usuario:Usuario){
    console.log("Se edita usuario ");
    return this.http.put<any>(this.baseEndPoint + '/pagos/usuarios/'+documento, usuario)
      .pipe(map(res => {
        console.log("Service response : ", res);
        return res;
      }));
  }



}
