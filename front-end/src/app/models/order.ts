import {OrderLine} from "./order-line";
import {User} from "./user";

export class Order {
  public orderLines: OrderLine[];
  public user: User;
}
