import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {OrderLineComponent} from './order-line/order-line.component';
import {SharedModule} from "../shared/shared.module";
import {OrderLineService} from "../../services/order-line.service";
import {OrderComponent} from './order/order.component';
import {ProductService} from "../../services/product.service";

@NgModule({
  declarations: [
    OrderLineComponent,
    OrderComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    OrderLineComponent
  ],
  providers: [
    OrderLineService,
    ProductService
  ]
})
export class OrderModule {
}
