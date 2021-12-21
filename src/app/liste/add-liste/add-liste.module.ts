import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AddListePageRoutingModule } from './add-liste-routing.module';

import { AddListePage } from './add-liste.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AddListePageRoutingModule
  ],
  declarations: [AddListePage]
})
export class AddListePageModule {}
