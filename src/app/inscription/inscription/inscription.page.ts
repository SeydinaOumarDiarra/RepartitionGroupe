import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertController, LoadingController } from '@ionic/angular';
import { InscriptionServiceService } from '../service/inscription-service.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.page.html',
  styleUrls: ['./inscription.page.scss'],
})
export class InscriptionPage implements OnInit {
sign = {nom: '', prenom: '', login: '', password: ''};
formateur: any;
  constructor(
    private router: Router,
    private service: InscriptionServiceService,
    private loading: LoadingController,
    public alertController: AlertController,
  ) { }

  ngOnInit() {
  }

  home(){
    this.router.navigate(['home']);
  }


  async presentAlertLogin(){
    const alert = await this.alertController.create({
      header:'alert',
      subHeader: 'Nom d\'utilisateur existant',
      message: 'Le nom d\'utilisateur existe déjà !',
      buttons: ['ok']
    });
    await alert.present();
  }

  async presentAlertPassword(){
    const alert = await this.alertController.create({
      header:'alert',
      subHeader: 'Mot de passe incorrecte',
      message: 'Les deux mots de passe sont différents !',
      buttons: ['ok']
    });
    await alert.present();
  }

  async onSign(form: NgForm){
    const load = await this.loading.create({
      message: 'Patientez...',
      backdropDismiss: false,
      mode: 'ios'
    });
    await load.present();
    this.formateur = {nom: form.value["nom"], prenom: form.value["prenom"], login: form.value["login"], password: form.value["password"]};
    if(form.value["password"] == form.value["repeatpassword"]){
      this.service.verifieLogin(form.value["login"]).subscribe((data: any)=>{
        if(data == null){
          this.service.inscription(this.formateur)      
          .subscribe((response: any) => {
                  load.dismiss();
                  localStorage.setItem('userData', JSON.stringify(response));
                  this.router.navigate(['/accueil']);
              }
          );
        }else{
          load.dismiss();
          this.presentAlertLogin();
        }
      })
    }else{
      load.dismiss();
      this.presentAlertPassword();
    }
  }


}
