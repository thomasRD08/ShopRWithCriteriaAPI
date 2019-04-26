import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../shared/shared.module";
import {OverviewLpComponent} from './overview-lp/overview-lp.component';
import {OverviewGameComponent} from './overview-game/overview-game.component';
import {LpService} from "../../services/lp.service";
import {GameService} from "../../services/game.service";
import {FictionService} from "../../services/fiction.service";
import {NonFictionService} from "../../services/non-fiction.service";
import {OverviewFictionComponent} from './overview-fiction/overview-fiction.component';
import {OverviewNonFictionComponent} from './overview-non-fiction/overview-non-fiction.component';

@NgModule({
  declarations: [
    OverviewLpComponent,
    OverviewGameComponent,
    OverviewFictionComponent,
    OverviewNonFictionComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    OverviewLpComponent,
    OverviewGameComponent,
    OverviewFictionComponent,
    OverviewNonFictionComponent
  ],
  providers: [
    LpService,
    GameService,
    FictionService,
    NonFictionService
  ]
})
export class OverviewProductModule {
}
