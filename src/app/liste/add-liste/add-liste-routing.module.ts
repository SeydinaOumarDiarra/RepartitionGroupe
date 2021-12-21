import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddListePage } from './add-liste.page';

const routes: Routes = [
  {
    path: '',
    component: AddListePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AddListePageRoutingModule {}
