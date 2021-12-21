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
  
}
