import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {UserService} from "../../services/user.service";
import {SharedModule} from "../shared/shared.module";
import {AuthService} from "../../services/auth.service";

@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    LoginComponent,
    RegisterComponent
  ],
  providers: [
    UserService,
    AuthService
  ]
})
export class AuthModule {
}
