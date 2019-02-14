import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../shared/shared.module";
import {LpService} from "../../services/lp.service";
import {GameService} from "../../services/game.service";
import {FictionService} from "../../services/fiction.service";
import {NonFictionService} from "../../services/non-fiction.service";
import {CreateUpdateLpComponent} from './create-update-lp/create-update-lp.component';
import {CreateUpdateGameComponent} from './create-update-game/create-update-game.component';
import {CreateUpdateFictionComponent} from './create-update-fiction/create-update-fiction.component';
import {CreateUpdateNonFictionComponent} from './create-update-non-fiction/create-update-non-fiction.component';

@NgModule({
  declarations: [
    CreateUpdateLpComponent,
    CreateUpdateGameComponent,
    CreateUpdateFictionComponent,
    CreateUpdateNonFictionComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    CreateUpdateLpComponent,
    CreateUpdateGameComponent,
    CreateUpdateFictionComponent,
    CreateUpdateNonFictionComponent
  ],
  providers: [
    LpService,
    GameService,
    FictionService,
    NonFictionService
  ]
})
export class CreateUpdateProductModule {
}
