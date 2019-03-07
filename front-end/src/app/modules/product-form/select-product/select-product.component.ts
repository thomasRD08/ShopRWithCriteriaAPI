import {Component, OnInit} from '@angular/core';
import {ProductTypes} from "../../../models/product-types";

@Component({
  selector: 'app-select-product',
  templateUrl: './select-product.component.html',
  styleUrls: ['./select-product.component.scss']
})
export class SelectProductComponent implements OnInit {
  productType: string;

  constructor() { }

  ngOnInit() {
  }

  getProductTypeEnumValues(): string[] {
    return Object.keys(ProductTypes).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }
}
