import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DynamicFormComponent} from './dynamic-form/dynamic-form.component';
import {FormControlComponent} from './form-control/form-control.component';
import {SharedModule} from "../shared/shared.module";

@NgModule({
  declarations: [
    DynamicFormComponent,
    FormControlComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    DynamicFormComponent,
    FormControlComponent
  ]
})
export class DynamicFormModule {
}
