import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./modules/auth/login/login.component";
import {RegisterComponent} from "./modules/auth/register/register.component";
import {OverviewFictionComponent} from "./modules/overview-product/overview-fiction/overview-fiction.component";
import {OverviewNonFictionComponent} from "./modules/overview-product/overview-non-fiction/overview-non-fiction.component";
import {OverviewLpComponent} from "./modules/overview-product/overview-lp/overview-lp.component";
import {OverviewGameComponent} from "./modules/overview-product/overview-game/overview-game.component";
import {CreateUpdateLpComponent} from "./modules/create-update-product/create-update-lp/create-update-lp.component";
import {CreateUpdateGameComponent} from "./modules/create-update-product/create-update-game/create-update-game.component";
import {CreateUpdateFictionComponent} from "./modules/create-update-product/create-update-fiction/create-update-fiction.component";
import {CreateUpdateNonFictionComponent} from "./modules/create-update-product/create-update-non-fiction/create-update-non-fiction.component";
import {DetailLpComponent} from "./modules/detail-product/detail-lp/detail-lp.component";
import {DetailGameComponent} from "./modules/detail-product/detail-game/detail-game.component";
import {DetailFictionComponent} from "./modules/detail-product/detail-fiction/detail-fiction.component";
import {DetailNonFictionComponent} from "./modules/detail-product/detail-non-fiction/detail-non-fiction.component";
import {OrderComponent} from "./modules/order/order/order.component";
import {SelectProductComponent} from "./modules/product-form/select-product/select-product.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'products/create', component: SelectProductComponent},
  {path: 'products/lp', component: OverviewLpComponent},
  {path: 'products/lp/create', component: CreateUpdateLpComponent},
  {path: 'products/lp/:id', component: DetailLpComponent},
  {path: 'products/lp/:id/edit', component: CreateUpdateLpComponent},
  {path: 'products/game', component: OverviewGameComponent},
  {path: 'products/game/create', component: CreateUpdateGameComponent},
  {path: 'products/game/:id', component: DetailGameComponent},
  {path: 'products/game/:id/edit', component: CreateUpdateGameComponent},
  {path: 'products/books/fiction', component: OverviewFictionComponent},
  {path: 'products/books/fiction/create', component: CreateUpdateFictionComponent},
  {path: 'products/books/fiction/:id', component: DetailFictionComponent},
  {path: 'products/books/fiction/:id/edit', component: CreateUpdateFictionComponent},
  {path: 'products/books/non-fiction', component: OverviewNonFictionComponent},
  {path: 'products/books/non-fiction/create', component: CreateUpdateNonFictionComponent},
  {path: 'products/books/non-fiction/:id', component: DetailNonFictionComponent},
  {path: 'products/books/non-fiction/:id/edit', component: CreateUpdateNonFictionComponent},
  {path: 'cart', component: OrderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
