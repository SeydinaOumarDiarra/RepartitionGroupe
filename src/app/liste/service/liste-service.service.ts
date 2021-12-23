import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ListeServiceService {

  url = environment.URL;
  constructor(
    private http: HttpClient,
  ) { }
  
  //ajout liste
  addListe(data: any){
    return this.http.post(this.url + '/ajoutListe', data)
  }

   //ajout liste excel
   addListeExcel(data: any){
    return this.http.post(this.url + '/ajoutApprenants', data)
  }

  //Apprenant par liste
  detailListe(id: any){
    return this.http.get(this.url +`/liste/${id}`);
  }
  //Apprenant par liste
  appByListe(data: any){
    return this.http.get(this.url +`/listeApprenantdistinct/${data}`);
  }

}
