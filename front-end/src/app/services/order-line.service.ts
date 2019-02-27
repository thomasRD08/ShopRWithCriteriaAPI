import {Injectable} from '@angular/core';
import {OrderLine} from "../models/order-line";
import {GlobalConstant} from "../modules/shared/global-constant";

@Injectable({
  providedIn: 'root'
})
export class OrderLineService {
  constructor() {
  }

  addOrderLineToOrderLocalStorage(order: OrderLine[], orderLine: OrderLine): void {
    order.push(orderLine);
    localStorage.setItem(GlobalConstant.ORDER, JSON.stringify(order));
  }

  getCurrentOrderLines(): OrderLine[] {
    return JSON.parse(localStorage.getItem(GlobalConstant.ORDER));
  }

  deleteOrderLocalStorage(): void {
    localStorage.removeItem(GlobalConstant.ORDER);
  }
}
