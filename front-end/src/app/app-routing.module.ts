import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./components/auth/login/login.component";
import {RegisterComponent} from "./components/auth/register/register.component";
import {ProductsComponent} from "./components/overview/products/products.component";
import {BooksComponent} from "./components/overview/books/books.component";
import {FictionComponent} from "./components/overview/fiction/fiction.component";
import {NonFictionComponent} from "./components/overview/non-fiction/non-fiction.component";
import {LpsComponent} from "./components/overview/lps/lps.component";
import {GamesComponent} from "./components/overview/games/games.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'products/books', component: BooksComponent},
  {path: 'products/books/fiction', component: FictionComponent},
  {path: 'products/books/non-fiction', component: NonFictionComponent},
  {path: 'products/lps', component: LpsComponent},
  {path: 'products/games', component: GamesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
