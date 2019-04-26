import {Product} from "./product";

export class Game extends Product{
  publisher: string;
  gameMinAge: string;
  gameGenre: string;

  constructor(
    type: string,
    id?: number,
    title?: string,
    price?: number,
    publisher?: string,
    gameMinAge?: string,
    gameGenre?: string) {
    super(type, id, title, price);
    this.publisher = publisher;
    this.gameMinAge = gameMinAge;
    this.gameGenre = gameGenre;
  }
}
