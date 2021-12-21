import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AccueilServiceService {
  url = environment.URL;
  constructor(
    private http: HttpClient,
  ) { }

  // Liste par formateur
  listeByFormateur(data: any){
    return this.http.get(this.url +`/listeFormateur/${data}`);
  }
}
