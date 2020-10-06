import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pago } from './pago';
import { environment } from '../../core/environment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PagoService {
  private baseEndPoint = environment.endpointBackend;
 // private cabeceras: HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  httpOptions = {
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*',
      'Content-Type':'application/json'
    })
  };

  constructor(protected http: HttpClient) { }


  public listar(): Observable<Pago[]>{
    return this.http.get<Pago[]>(this.baseEndPoint+'/pagos/listar');
  }


  public agregarPago(pago:Pago){
    console.log("Se agregara pago ");
    return this.http.post<any>(this.baseEndPoint + '/pagos', pago)
      .pipe(map(res => {
        console.log("Service response : ", res);
        return res;
      }));
  }

}
