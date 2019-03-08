import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {FormFactoryService} from "../../../services/form/form-factory.service";
import {LpService} from "../../../services/lp.service";
import {GameService} from "../../../services/game.service";
import {FictionService} from "../../../services/fiction.service";
import {NonFictionService} from "../../../services/non-fiction.service";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss'],
  providers: [FormFactoryService]
})
export class ProductFormComponent implements OnInit, OnChanges {
  @Input() productType: string;
  controls: any[];

  constructor(private ffs: FormFactoryService, private lpService: LpService, private gameService: GameService,
              private fictionService: FictionService, private nonFictionService: NonFictionService) {}

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    switch (this.productType) {
      case 'Lp': {
        this.lpService.getLpGenreLabels().subscribe(genres =>
          this.controls = this.ffs.getLpForm(genres)
        );
        break;
      }
      case 'Game': {
        this.gameService.getGameMinAgeLabels().subscribe(minAges =>
          this.gameService.getGameGenreLabels().subscribe(genres =>
            this.controls = this.ffs.getGameForm(genres, minAges)
          ));
        break;
      }
      case 'Fiction': {
        this.fictionService.getFictionGenreLabels().subscribe(genres =>
          this.controls = this.ffs.getFictionForm(genres)
        );
        break;
      }
      case 'Non-fiction': {
        this.nonFictionService.getNonFictionSubjectLabels().subscribe(subjects =>
          this.controls = this.ffs.getNonFictionForm(subjects)
        );
        break;
      }
      default: {
        break;
      }
    }
  }
}
