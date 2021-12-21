import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'login',
    loadChildren: () => import('./login/login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'accueil',
    loadChildren: () => import('./accueil/accueil/accueil.module').then( m => m.AccueilPageModule)
  },
  {
    path: 'add-liste',
    loadChildren: () => import('./liste/add-liste/add-liste.module').then( m => m.AddListePageModule)
  },
  {
    path: 'liste/:id',
    loadChildren: () => import('./liste/liste/liste.module').then( m => m.ListePageModule)
  },
  {
    path: 'add-groupe',
    loadChildren: () => import('./groupe/add-groupe/add-groupe.module').then( m => m.AddGroupePageModule)
  },
  {
    path: 'collection',
    loadChildren: () => import('./groupe/collection/collection.module').then( m => m.CollectionPageModule)
  },
  {
    path: 'detailcollection',
    loadChildren: () => import('./groupe/detailcollection/detailcollection.module').then( m => m.DetailcollectionPageModule)
  },
  {
    path: 'inscription',
    loadChildren: () => import('./inscription/inscription/inscription.module').then( m => m.InscriptionPageModule)
  },
  
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
