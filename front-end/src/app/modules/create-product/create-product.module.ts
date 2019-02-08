import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../shared/shared.module";
import {LpService} from "../../services/lp.service";
import {GameService} from "../../services/game.service";
import {FictionService} from "../../services/fiction.service";
import {NonFictionService} from "../../services/non-fiction.service";
import {CreateLpComponent} from './create-lp/create-lp.component';
import {CreateGameComponent} from './create-game/create-game.component';
import {CreateFictionComponent} from './create-fiction/create-fiction.component';
import {CreateNonFictionComponent} from './create-non-fiction/create-non-fiction.component';

@NgModule({
  declarations: [
    CreateLpComponent,
    CreateGameComponent,
    CreateFictionComponent,
    CreateNonFictionComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    CreateLpComponent,
    CreateGameComponent,
    CreateFictionComponent,
    CreateNonFictionComponent
  ],
  providers: [
    LpService,
    GameService,
    FictionService,
    NonFictionService
  ]
})
export class CreateProductModule {
}
