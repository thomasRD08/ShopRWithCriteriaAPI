import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SharedModule} from "./modules/shared/shared.module";
import {AuthModule} from "./modules/auth/auth.module";
import {OverviewProductModule} from "./modules/overview-product/overview-product.module";
import {CreateProductModule} from "./modules/create-product/create-product.module";

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
    CreateProductModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
