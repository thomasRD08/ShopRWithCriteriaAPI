import {Product} from "./product";

export abstract class Book extends Product{
  public author: string;
  public isbn: string;
  public pages: string;

  protected constructor(public type: string) {
    super(type);
  }
}
