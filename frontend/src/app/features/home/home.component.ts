import { Component, OnInit } from '@angular/core';
import { HomeTrmService } from './Hometrm.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  trm: string;
  public error:String;

  constructor(private trmService: HomeTrmService) {
    this.error=null;
    this.trmService.getTrm().subscribe(data => {
      this.trm = data["data"]["value"]
      console.log(data)
      },
      error=>{
      console.log("Este es el error"+error.message),
      this.error = error["error"]["message"]
     }   
   );
  }
  ngOnInit(): void {
  }

}
