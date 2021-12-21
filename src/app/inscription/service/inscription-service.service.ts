import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InscriptionServiceService {

  url = environment.URL;
  constructor(
    private http: HttpClient
  ) { }

  //inscription formateur
  inscription(data: any){
    return this.http.post(this.url + '/ajoutFormateur', data);
  }

   //verification login formateur
   verifieLogin(login: any){
    return this.http.get(this.url + `/verifiLogin/${login}`);
  }
}
