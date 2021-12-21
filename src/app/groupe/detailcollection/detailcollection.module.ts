import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { DetailcollectionPageRoutingModule } from './detailcollection-routing.module';

import { DetailcollectionPage } from './detailcollection.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    DetailcollectionPageRoutingModule
  ],
  declarations: [DetailcollectionPage]
})
export class DetailcollectionPageModule {}
