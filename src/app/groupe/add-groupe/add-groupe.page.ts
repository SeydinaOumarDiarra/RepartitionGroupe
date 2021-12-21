import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-groupe',
  templateUrl: './add-groupe.page.html',
  styleUrls: ['./add-groupe.page.scss'],
})
export class AddGroupePage implements OnInit {
  groupe = {collection: '', nbre: '', membre:''};
  error = '';
  constructor() { }

  ngOnInit() {
  }

  addGroupe(form: NgForm){
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
