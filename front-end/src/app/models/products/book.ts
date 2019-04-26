import {Product} from "./product";

export abstract class Book extends Product{
  author: string;
  isbn: string;
  pages: string;

  protected constructor(
    type: string,
    id?: number,
    title?: string,
    price?: number,
    author?: string,
    isbn?: string,
    pages?: string) {
    super(type, id, title, price);
    this.author = author;
    this.isbn = isbn;
    this.pages = pages;
  }
}
