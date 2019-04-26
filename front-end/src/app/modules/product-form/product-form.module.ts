import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SelectProductComponent} from './select-product/select-product.component';
import {ProductFormComponent} from "./product-form/product-form.component";
import {SharedModule} from "../shared/shared.module";
import {DynamicFormModule} from "../dynamic-form/dynamic-form.module";

@NgModule({
  declarations: [
    SelectProductComponent,
    ProductFormComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    DynamicFormModule
  ]
})
export class ProductFormModule {
}
