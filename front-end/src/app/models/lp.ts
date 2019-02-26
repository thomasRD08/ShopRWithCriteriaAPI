import {Product} from "./product";

export class Lp extends Product {
  public artist: string;
  public lpGenre: string;

  constructor(public type: string) {
    super(type);
  }
}
