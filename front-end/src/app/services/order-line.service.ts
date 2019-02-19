import {Injectable} from '@angular/core';
import {OrderLine} from "../models/order-line";
import {GlobalConstant} from "../modules/shared/global-constant";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Order} from "../models/order";

@Injectable({
  providedIn: 'root'
})
export class OrderLineService {
  constructor(private http: HttpClient) {
  }

  addOrderLineToOrderLocalStorage(order: OrderLine[], orderLine: OrderLine): void {
      order.push(orderLine);
      localStorage.setItem(GlobalConstant.ORDER, JSON.stringify(order));
  }

  getCurrentOrderLines(): OrderLine[] {
    return JSON.parse(localStorage.getItem(GlobalConstant.ORDER));
  }

  createOrderLine(orderLine: OrderLine): Observable<OrderLine> {
    return this.http.post<OrderLine>('/api/order-lines', orderLine);
  }

  saveOrder(order: Order): Observable<Order> {
    return this.http.post<Order>('/api/order', order); //todo refactor to orderservice
  }
}
