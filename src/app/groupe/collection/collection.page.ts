import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ListeServiceService } from 'src/app/liste/service/liste-service.service';
import { GroupeServiceService } from '../service/groupe-service.service';

@Component({
  selector: 'app-collection',
  templateUrl: './collection.page.html',
  styleUrls: ['./collection.page.scss'],
})
export class CollectionPage implements OnInit {
id: any;
tache: any;
  constructor(
    public router: Router,
    private route: ActivatedRoute,
    private serviceList: ListeServiceService,
    private service: GroupeServiceService,

  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.service.afficherTacheParListe(this.id).subscribe((data: any)=>{
      this.tache = data;
      console.log(this.tache);
      
    });
  }

  detailCollection(data: any){
    //this.service.afficherGroupeParTache(data).subscribe
    this.router.navigate(['detailcollection', data]);
  }

}
