import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GroupeServiceService } from '../service/groupe-service.service';

@Component({
  selector: 'app-detailcollection',
  templateUrl: './detailcollection.page.html',
  styleUrls: ['./detailcollection.page.scss'],
})
export class DetailcollectionPage implements OnInit {
id: any;
groupe= []any;
  constructor(
    private route: ActivatedRoute,
    private serviceGroupe: GroupeServiceService,
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.serviceGroupe.afficherGroupeParTache(this.id).subscribe((data: any)=>{
      for(let i=0; i<data.length; i++){
        this.serviceGroupe.historiqueGroupe(data[i].id).subscribe((hist: any)=>{
          this.groupe.push(hist);
          console.log(this.groupe);
        })
      }
      
      console.log(this.groupe);
    });
  }

}
