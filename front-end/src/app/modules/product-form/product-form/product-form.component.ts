import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {FormFactoryService} from "../../../services/form/form-factory.service";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss'],
  providers: [FormFactoryService]
})
export class ProductFormComponent implements OnInit, OnChanges {
  @Input() productType: string;
  controls: any[];

  constructor(private ffs: FormFactoryService) {
  }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    switch (this.productType) {
      case 'Lp': {
        this.controls = this.ffs.getLpForm();
        break;
      }
      case 'Game': {
        this.controls = this.ffs.getGameForm();
        break;
      }
      case 'Fiction': {
        this.controls = this.ffs.getFictionForm();
        break;
      }
      case 'Non-fiction': {
        this.controls = this.ffs.getNonFictionForm();
        break;
      }
      default: {
        break;
      }
    }
  }
}
