import {AfterContentInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {OrderLine} from "../../../models/order-line";
import {OrderLineService} from "../../../services/order-line.service";

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

  constructor(private orderLineService: OrderLineService) {
  }

  ngOnInit() {
    this.dataSource.data = this.orderLineService.getCurrentOrderLines();
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

  confirm() {
  }
}
