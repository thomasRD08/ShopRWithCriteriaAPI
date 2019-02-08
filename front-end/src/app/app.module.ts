import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SharedModule} from "./components/shared/shared.module";
import {AuthModule} from "./components/auth/auth.module";
import {OverviewModule} from "./components/overview/overview.module";
import {CreateProductModule} from "./components/create-product/create-product.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    AuthModule,
    OverviewModule,
    CreateProductModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
