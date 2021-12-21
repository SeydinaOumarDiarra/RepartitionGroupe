import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccueilServiceService } from '../service/accueil-service.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.page.html',
  styleUrls: ['./accueil.page.scss'],
})
export class AccueilPage implements OnInit {
  user: any;
  formateur: any;
  listeApp: any;
  constructor(
    public router: Router,
    private service: AccueilServiceService
  ) { }

  ngOnInit() {
    this.user = localStorage.getItem('userData');
    this.formateur = JSON.parse(this.user);
    this.service.listeByFormateur(this.formateur.id).subscribe((data:any)=>{
      this.listeApp = data;
      console.log(this.listeApp);
      
    })
  }

  detailListe(data: any){
    console.log(data);
    this.router.navigate(['liste',data]);
  }
  logout(){
    localStorage.removeItem('userData');
    localStorage.clear();
    this.router.navigate(['login']);
  }

}
