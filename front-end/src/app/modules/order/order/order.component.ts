import {AfterContentInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {OrderLine} from "../../../models/order-line";
import {OrderLineService} from "../../../services/order-line.service";
import {Router} from "@angular/router";
import {AuthService} from "../../../services/auth.service";
import {Order} from "../../../models/order";
import {OrderService} from "../../../services/order.service";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit, AfterContentInit {
  displayedColumns: any[] = ['type', 'title', 'price', 'amount'];
  dataSource = new MatTableDataSource<OrderLine>();

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private orderLineService: OrderLineService, private orderService: OrderService, private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
    this.dataSource.data = this.orderLineService.getCurrentCart();
    if (this.dataSource.data == null) {
      this.dataSource.data = [];
    }
  }

  ngAfterContentInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  calculateTotalPrice(): number {
    let totalPrice: number = 0;
    this.dataSource.data.forEach(orderLine => totalPrice += orderLine.amount * orderLine.product.price);
    return totalPrice;
  }

  confirm(): void {
    if (this.authService.getCurrentUser() == null) {
      this.router.navigate(['/login']);
    } else {
      let order = new Order();

      order.orderLines = this.dataSource.data;
      order.user = this.authService.getCurrentUser();

      this.orderService.saveOrder(order).subscribe(() => {
        this.orderLineService.deleteCartLocalStorage();
        this.router.navigate(['']);
      });
    }
  }

  delete(): void {
    this.orderLineService.deleteCartLocalStorage();
    this.router.navigate([''])
  }
}
