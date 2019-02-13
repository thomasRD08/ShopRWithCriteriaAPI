import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LpService} from "../../services/lp.service";
import {GameService} from "../../services/game.service";
import {FictionService} from "../../services/fiction.service";
import {NonFictionService} from "../../services/non-fiction.service";
import {DetailFictionComponent} from './detail-fiction/detail-fiction.component';
import {DetailLpComponent} from './detail-lp/detail-lp.component';
import {DetailGameComponent} from './detail-game/detail-game.component';
import {DetailNonFictionComponent} from './detail-non-fiction/detail-non-fiction.component';
import {SharedModule} from "../shared/shared.module";

@NgModule({
  declarations: [
    DetailFictionComponent,
    DetailLpComponent,
    DetailGameComponent,
    DetailNonFictionComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [],
  providers: [
    LpService,
    GameService,
    FictionService,
    NonFictionService
  ]
})
export class DetailProductModule {
}
