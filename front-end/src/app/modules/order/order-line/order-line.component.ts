import {Component, Input, OnInit} from '@angular/core';
import {OrderLineService} from "../../../services/order-line.service";
import {OrderLine} from "../../../models/order-line";
import {ActivatedRoute} from "@angular/router";
import {Product} from "../../../models/products/product";
import {Location} from "@angular/common";

@Component({
  selector: 'app-order-line',
  templateUrl: './order-line.component.html',
  styleUrls: ['./order-line.component.scss']
})
export class OrderLineComponent implements OnInit {
  @Input()
  product: Product;
  orderLine: OrderLine;
  cart: OrderLine[];
  id: number;

  constructor(private orderLineService: OrderLineService, private route: ActivatedRoute, private location: Location) {
  }

  ngOnInit() {
    this.orderLine = new OrderLine();
  }

  addOrderLineToOrder(): void {
    this.orderLine.product = this.product;
    this.cart = this.orderLineService.getCurrentCart();
    if (this.cart == null) {
      this.cart = [];
    }
    this.orderLineService.addOrderLineToCartLocalStorage(this.cart, this.orderLine);
    this.location.back();
  }
}
