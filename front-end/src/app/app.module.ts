import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SharedModule} from "./modules/shared/shared.module";
import {AuthModule} from "./modules/auth/auth.module";
import {OverviewProductModule} from "./modules/overview-product/overview-product.module";
import {CreateUpdateProductModule} from "./modules/create-update-product/create-update-product.module";
import {DetailProductModule} from "./modules/detail-product/detail-product.module";
import {OrderModule} from "./modules/order/order.module";
import {DynamicFormModule} from "./modules/dynamic-form/dynamic-form.module";
import {ProductFormModule} from "./modules/product-form/product-form.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    AuthModule,
    OverviewProductModule,
    CreateUpdateProductModule,
    DetailProductModule,
    OrderModule,
    DynamicFormModule,
    ProductFormModule
  ],
  providers: [],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {
}
