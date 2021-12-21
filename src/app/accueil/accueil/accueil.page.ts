import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.page.html',
  styleUrls: ['./accueil.page.scss'],
})
export class AccueilPage implements OnInit {

  constructor(
    public router: Router,
  ) { }

  ngOnInit() {
  }

  liste(){
    this.router.navigate(['liste']);
  }
  logout(){
    this.router.navigate(['login']);
  }

}
