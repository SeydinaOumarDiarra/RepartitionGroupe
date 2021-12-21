import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ListeServiceService } from '../service/liste-service.service';

@Component({
  selector: 'app-liste',
  templateUrl: './liste.page.html',
  styleUrls: ['./liste.page.scss'],
})
export class ListePage implements OnInit {
 id: any;
 liste: any;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: ListeServiceService,
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.service.appByListe(this.id).subscribe((data: any)=>{
      this.liste = data;
    });
  }

}
