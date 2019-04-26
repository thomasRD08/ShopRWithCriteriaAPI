import {Book} from "./book";

export class NonFiction extends Book {
  nonFictionSubject: string;

  constructor(
    type: string,
    id?: number,
    title?: string,
    price?: number,
    author?: string,
    isbn?: string,
    pages?: string,
    nonFictionSubject?: string) {
    super(type, id, title, price, author, isbn, pages);
    this.nonFictionSubject = nonFictionSubject;
  }
}
