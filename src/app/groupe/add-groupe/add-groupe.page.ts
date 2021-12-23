import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { AlertController, LoadingController } from '@ionic/angular';
import { ListeServiceService } from 'src/app/liste/service/liste-service.service';
import { GroupeServiceService } from '../service/groupe-service.service';

@Component({
  selector: 'app-add-groupe',
  templateUrl: './add-groupe.page.html',
  styleUrls: ['./add-groupe.page.scss'],
})
export class AddGroupePage implements OnInit {
  groupe = {collection: '', nbre: '', membre:'', ordre:''};
  error = '';
  id: any;
  tab: any;
  liste: any;
  detailList: any;
  collection: any;
  groupeAdd: any;
  groupeApp: any;
  formats: any;
  groupa: any;
  format: any;
  resteApp = [];
  cpte = 0;
  multi = 0;
  constructor(  
    private loading: LoadingController,
    private route: ActivatedRoute,
    public alertController: AlertController,
    private service: GroupeServiceService,
    private serviceList: ListeServiceService,
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    console.log(this.id);
    this.serviceList.appByListe(this.id).subscribe((data: any)=>{
      for(let i=0; i<data.length; i++){
        this.cpte = this.cpte + 1;
      }
      this.liste = data;
    });

    this.serviceList.detailListe(this.id).subscribe((dat: any)=>{
      this.detailList = dat;
      console.log(dat);
      
    })

    this.formats = localStorage.getItem('userData');
     this.format = JSON.parse(this.formats)
  }

  // Alerte pour membre par groupe superieur
  async presentAlertMembre(){
    const alert = await this.alertController.create({
      header:'alert',
      subHeader: 'Nombre de membre volumineux',
      message: 'Le nombre de membre choisi est superieur à celui de la liste !',
      buttons: ['ok']
    });
    await alert.present();
  }

   // Alerte pour nbre de groupe ou nbre de membre inferieur à 0
   async presentAlertInferieur(){
    const alert = await this.alertController.create({
      header:'alert',
      subHeader: 'Nombre non permi',
      message: 'choisissez un nombre supérieur à 0 pour les groupes et un nombre superieur à 1 pour les membres!',
      buttons: ['ok']
    });
    await alert.present();
  }

  // Alerte pour des groupes qui seront vides
  async presentAlertGroupeVide(){
    const alert = await this.alertController.create({
      header:'alert',
      subHeader: 'Risque de groupe(s) vide(s)',
      message: 'Vous risquez d\'avoir de groupe(s) vide(s) !',
      buttons: ['ok']
    });
    await alert.present();
  }

  //  // Alerte pour des membre qui seront pas affectés
  //  async presentAlertMembreNonAffecter(){
  //   const alert = await this.alertController.create({
  //     header:'alert',
  //     subHeader: 'Risque de membre(s) non affecté(s)',
  //     message: 'Vous risquez d\'avoir des membres non affecté(s) !',
  //     buttons: ['ok']
  //   });
  //   await alert.present();
  // }

  async addGroupe(form: NgForm){
    const load = await this.loading.create({
      message: 'Patientez...',
      backdropDismiss: false,
      mode: 'ios'
    });
    await load.present();

    this.multi = form.value["nbre"] * form.value["membre"];

    console.log(form.value);
    // verifier si nbre de groupe ou nbre de membre inferieur à 0
    if(form.value["nbre"] <=0 || form.value["membre"]<=1){
      load.dismiss();
      this.presentAlertInferieur();
    }
    else{

      // verifier si le nombre de membre choisi est supérieur aux membres de la liste
      if(form.value["membre"] > this.cpte){
        load.dismiss();
        this.presentAlertMembre();
      }
      else{

        // verifier si le nbre de groupe est supérieur ou égale au nbre de membre choisi
        // et que leurs multiplication est superieur au nbre de membres de la liste
        if(form.value["nbre"] >= form.value["membre"] && this.multi > this.cpte){
          load.dismiss();
          this.presentAlertGroupeVide();
        }
        else{

          // verifier si le choix de partage est aléatoire
          if(form.value["ordre"] == "Aléatoire"){
            load.dismiss();
            console.log("Aléatoire");
            
            console.log("collection______", form.value["collection"]);
            
    
            this.collection = {date_ajout: new Date(), description: form.value["collection"], liste: this.detailList}
            // créer la collection
              this.service.ajoutTache(this.collection).subscribe((collect: any)=>{

                
                // créer le nombre de groupe demandé
                for(let i=0; i< form.value["nbre"]; i++){
                  this.resteApp = [];
                  this.groupeAdd = {nom_groupe: "Groupe "+(i+1), formateur: this.format, tache: collect}
                  this.service.ajoutGroupe(this.groupeAdd).subscribe((group: any)=>{
                    this.groupa = group;
                   

                    for(let j=0; j<form.value["membre"]; j++){
                      
                      //choisir aléatoirement une valeur dans la liste
                      var rand = Math.floor(Math.random()*(this.liste).length);
 
                      //stocker l'index de la valeur trouvée
                      var rValue = this.liste[rand];
 
                     // création de groupe_apprenant
                     this.groupeApp = {apprenant: rValue, groupe: group};
                     console.log("groupe apprenant===== ",this.groupeApp);

                     this.service.ajoutGroupeApp(this.groupeApp).subscribe((ag: any)=>{
                      console.log("fait");});

                      //supprimer la valeur trouvée de la liste
                      if (rand !== -1) {
                        this.liste.splice(rand, 1);
                      }
                      console.log(this.liste);
                       //this.resteApp = this.liste;
                     if(j == form.value["membre"]-1){
                       this.resteApp.push(this.liste);
                      }
                      
                   }
                   
                 })
                 console.log(this.liste);
                
                }

                console.log(this.resteApp);
                 console.log(this.liste[0]);
                console.log(this.groupa);

                if(this.resteApp.length != 0){
                  console.log("reste");
                  
                  for (let j=0; j<this.resteApp.length; j++){
                     //choisir aléatoirement une valeur dans la liste des groupes créés
                      var rand = Math.floor(Math.random()*(this.groupa).length);

                    //stocker l'index de la valeur trouvée
                     var rValue = this.groupa[rand];

                    // création de groupe_apprenant
                     var groupeApp = {apprenant: this.resteApp[j], groupe: rValue};

                     this.service.ajoutGroupeApp(groupeApp).subscribe((agi: any)=>{

                      //supprimer la valeur trouvée de la liste
                      if (rand !== -1) {
                        this.resteApp.splice(rand, 1);
                      }
                     })
                     
                  }
                }

               // console.log(this.tab);
                
                //this.tab = this.liste;

                
                

                // if(this.tab.length != 0){
                  
                // }
              })
            
            
          }else{
             // verifier si le choix de partage est par ordre
            if(form.value["ordre"] == "Par ordre"){
              load.dismiss();
              console.log("Par ordre");
              this.collection = {date_ajout: new Date(), description: form.value["collection"], liste: this.detailList}
              // créer la collection
              this.service.ajoutTache(this.collection).subscribe((collect: any)=>{

                
                // créer le nombre de groupe demandé
                for(let i=0; i< form.value["nbre"]; i++){
                  this.resteApp = [];
                  this.groupeAdd = {nom_groupe: "Groupe "+(i+1), formateur: this.format, tache: collect}
                  this.service.ajoutGroupe(this.groupeAdd).subscribe((group: any)=>{
                    this.groupa = group;
                   

                    for(let j=0; j<form.value["membre"]; j++){
                      
                      
 
                      //stocker l'index de la valeur trouvée
                      var rValue = this.liste[j];
 
                     // création de groupe_apprenant
                     this.groupeApp = {apprenant: rValue, groupe: group};
                     console.log("groupe apprenant===== ",this.groupeApp);

                     this.service.ajoutGroupeApp(this.groupeApp).subscribe((ag: any)=>{
                      console.log("fait");});

                      //supprimer la valeur trouvée de la liste
                      if (j !== -1) {
                        this.liste.splice(j, 1);
                      }
                      console.log(this.liste);
                       //this.resteApp = this.liste;
                     if(j == form.value["membre"]-1){
                       this.resteApp.push(this.liste);
                      }
                      
                   }
                   
                 })
                 console.log(this.liste);
                
                }

                console.log(this.resteApp);
                 console.log(this.liste[0]);
                console.log(this.groupa);

                if(this.resteApp.length != 0){
                  console.log("reste");
                  
                  for (let j=0; j<this.resteApp.length; j++){
                     //choisir aléatoirement une valeur dans la liste des groupes créés
                      var rand = Math.floor(Math.random()*(this.groupa).length);

                    //stocker l'index de la valeur trouvée
                     var rValue = this.groupa[rand];

                    // création de groupe_apprenant
                     var groupeApp = {apprenant: this.resteApp[j], groupe: rValue};

                     this.service.ajoutGroupeApp(groupeApp).subscribe((agi: any)=>{

                      //supprimer la valeur trouvée de la liste
                      if (rand !== -1) {
                        this.resteApp.splice(rand, 1);
                      }
                     })
                     
                  }
                }

               // console.log(this.tab);
                
                //this.tab = this.liste;

                
                

                // if(this.tab.length != 0){
                  
                // }
              })
            }
          }
          
        }
      }
    }
    
    
    var myArray = ['one', 'two', 'three', 'four', 'five'];
    //choisir aléatoirement une valeur dans le tableau
    var rand = Math.floor(Math.random()*myArray.length);

    //stocker l'index de la valeur trouvée
    var rValue = myArray[rand];
    
    //supprimer la valeur trouvée
    if (rand !== -1) {
      myArray.splice(rand, 1);
  }
    console.log("index========", rand)
    console.log("valeur========",rValue)
    console.log("tab========",myArray)
  }

}
