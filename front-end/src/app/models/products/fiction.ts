import {Book} from "./book";

export class Fiction extends Book{
  fictionGenre: string;
  summary: string;

  constructor(
    type: string,
    id?: number,
    title?: string,
    price?: number,
    author?: string,
    isbn?: string,
    pages?: string,
    fictionGenre?: string,
    summary?: string) {
    super(type, id, title, price, author, isbn, pages);
    this.fictionGenre = fictionGenre;
    this.summary = summary;
  }
}
