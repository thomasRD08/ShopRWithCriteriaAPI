import {Injectable} from '@angular/core';
import {OrderLine} from "../models/order-line";
import {GlobalConstant} from "../modules/shared/global-constant";

@Injectable({
  providedIn: 'root'
})
export class OrderLineService {
  constructor() {
  }

  addOrderLineToCartLocalStorage(cart: OrderLine[], orderLine: OrderLine): void {
    cart.push(orderLine);
    localStorage.setItem(GlobalConstant.CART, JSON.stringify(cart));
  }

  getCurrentCart(): OrderLine[] {
    return JSON.parse(localStorage.getItem(GlobalConstant.CART));
  }

  deleteCartLocalStorage(): void {
    localStorage.removeItem(GlobalConstant.CART);
  }
}
