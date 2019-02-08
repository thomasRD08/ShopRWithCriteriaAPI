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

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'overview/products', component: ProductsComponent},
  {path: 'overview/products/lps', component: LpsComponent},
  {path: 'overview/products/games', component: GamesComponent},
  {path: 'overview/products/books', component: BooksComponent},
  {path: 'overview/products/books/fiction', component: FictionComponent},
  {path: 'overview/products/books/non-fiction', component: NonFictionComponent},
  {path: 'create/products/lp', component: CreateLpComponent},
  {path: 'create/products/game', component: CreateGameComponent},
  {path: 'create/products/fiction', component: CreateFictionComponent},
  {path: 'create/products/non-fiction', component: CreateNonFictionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
