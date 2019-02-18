import {Component, OnInit} from '@angular/core';
import {OrderLineService} from "../../../services/order-line.service";
import {OrderLine} from "../../../models/order-line";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../../services/product.service";

@Component({
  selector: 'app-order-line',
  templateUrl: './order-line.component.html',
  styleUrls: ['./order-line.component.scss']
})
export class OrderLineComponent implements OnInit {
  orderLine: OrderLine;
  order: OrderLine[];
  id: number;

  constructor(private orderLineService: OrderLineService, private productService: ProductService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.orderLine = new OrderLine();
    this.route.params.subscribe((params) => {
      this.id = params['id'];
      this.productService.getProductById(this.id).subscribe(data => this.orderLine.product = data);
    });
  }

  addOrderLineToOrder(): void {
    this.order = this.orderLineService.getCurrentOrderLines();
    if (this.order == null) {
      this.order = [];
    }
    this.orderLineService.addOrderLineToOrderLocalStorage(this.order, this.orderLine);
    this.router.navigate(['/cart']);
  }
}
