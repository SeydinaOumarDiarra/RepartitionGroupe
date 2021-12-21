import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertController, LoadingController } from '@ionic/angular';
import { LoginServiceService } from '../service/login-service.service';

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
    private service: LoginServiceService,
    private loading: LoadingController,
    public alertController: AlertController,
  ) { }

  ngOnInit() {
  }

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
  


  async onLogin(form: NgForm) {
    const load = await this.loading.create({
      message: 'Patientez...',
      backdropDismiss: false,
      mode: 'ios'
    });
    await load.present();
    this.service.connexion(form.value["username"], form.value["password"])      
    .subscribe((response: any) => {
     // console.log(response);
            load.dismiss();
            if(response){
              localStorage.setItem('userData', JSON.stringify(response));
              this.router.navigate(['/accueil']);
            }else{
              this.presentAlert();
            }
        }
    );
  }
 

}
