import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertController, LoadingController } from '@ionic/angular';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  login = {username: '', password: ''};
  error = '';
  constructor(
    public router: Router,
    private loading: LoadingController,
   // private http: HttpClient,
    public alertController: AlertController,
  ) { }


  async presentAlert(){
    const alert = await this.alertController.create({
      header:'alert',
      subHeader: 'Connexion échouée',
      message: 'Identifiant incorrect !',
      buttons: ['ok']
    });
    await alert.present();
  }

  home(){
    this.router.navigate(['home']);
  }
  ngOnInit() {
  }


  async onLogin(form: NgForm) {
    //this.submitted = true;
    console.log(form);
    
    this.router.navigate(['accueil']);
  }
 

}
