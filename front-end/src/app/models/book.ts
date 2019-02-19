import {Product} from "./product";

export abstract class Book extends Product{
  public author: string;
  public isbn: string;
  public pages: string;
}
