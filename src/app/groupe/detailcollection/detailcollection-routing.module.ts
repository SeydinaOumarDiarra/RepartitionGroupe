import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DetailcollectionPage } from './detailcollection.page';

const routes: Routes = [
  {
    path: '',
    component: DetailcollectionPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DetailcollectionPageRoutingModule {}
