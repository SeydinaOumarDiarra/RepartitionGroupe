import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-collection',
  templateUrl: './collection.page.html',
  styleUrls: ['./collection.page.scss'],
})
export class CollectionPage implements OnInit {

  constructor(
    public router: Router,
  ) { }

  ngOnInit() {
  }

  detailCollection(){
    this.router.navigate(['detailcollection']);
  }

}
