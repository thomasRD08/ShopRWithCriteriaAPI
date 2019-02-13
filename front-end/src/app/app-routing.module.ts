import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./modules/auth/login/login.component";
import {RegisterComponent} from "./modules/auth/register/register.component";
import {ProductsComponent} from "./modules/overview-product/products/products.component";
import {BooksComponent} from "./modules/overview-product/books/books.component";
import {FictionComponent} from "./modules/overview-product/fiction/fiction.component";
import {NonFictionComponent} from "./modules/overview-product/non-fiction/non-fiction.component";
import {LpsComponent} from "./modules/overview-product/lps/lps.component";
import {GamesComponent} from "./modules/overview-product/games/games.component";
import {CreateLpComponent} from "./modules/create-product/create-lp/create-lp.component";
import {CreateGameComponent} from "./modules/create-product/create-game/create-game.component";
import {CreateFictionComponent} from "./modules/create-product/create-fiction/create-fiction.component";
import {CreateNonFictionComponent} from "./modules/create-product/create-non-fiction/create-non-fiction.component";
import {DetailLpComponent} from "./modules/detail-product/detail-lp/detail-lp.component";
import {DetailGameComponent} from "./modules/detail-product/detail-game/detail-game.component";
import {DetailFictionComponent} from "./modules/detail-product/detail-fiction/detail-fiction.component";
import {DetailNonFictionComponent} from "./modules/detail-product/detail-non-fiction/detail-non-fiction.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'products/lp', component: LpsComponent},
  {path: 'products/lp/create', component: CreateLpComponent},
  {path: 'products/lp/:id', component: DetailLpComponent},
  {path: 'products/game', component: GamesComponent},
  {path: 'products/game/create', component: CreateGameComponent},
  {path: 'products/game/:id', component: DetailGameComponent},
  {path: 'products/books', component: BooksComponent},
  {path: 'products/books/fiction', component: FictionComponent},
  {path: 'products/books/fiction/create', component: CreateFictionComponent},
  {path: 'products/books/fiction/:id', component: DetailFictionComponent},
  {path: 'products/books/non-fiction', component: NonFictionComponent},
  {path: 'products/books/non-fiction/create', component: CreateNonFictionComponent},
  {path: 'products/books/non-fiction/:id', component: DetailNonFictionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
