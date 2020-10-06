import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class HomeTrmService {
  urlTrm: string;
  bodyTrm: string;
  response: Observable<string>;
  value:string;

  httpOptions = {
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*',
      'Authorization':'authkey',
      'userid':'1'
    })
  };

  constructor(private http: HttpClient,
    private datePipe: DatePipe) {      
    this.urlTrm = "https://trm-colombia.makaw-dev.now.sh/?date="+this.datePipe.transform(new Date(), "yyyy-MM-dd");
  }
  getTrm() {
    console.log("Se va obetener la trm");
   return this.http.get<string>(this.urlTrm);   


  }
}