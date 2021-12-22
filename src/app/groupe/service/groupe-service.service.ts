import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GroupeServiceService {

  url = environment.URL;
  constructor(
    private http: HttpClient,
  ) { }
  
  // création de tache
  ajoutTache(data: any){
    return this.http.post(this.url +'/ajoutTache', data);
  }

  // création de groupe
  ajoutGroupe(data: any){
    return this.http.post(this.url +'/ajoutGroupe', data);
  }

  // création de groupe_apprenant
  ajoutGroupeApp(data: any){
    return this.http.post(this.url +'/ajoutGroupeApprenant', data);
  }
}
