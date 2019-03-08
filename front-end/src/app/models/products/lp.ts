import {Product} from "./product";

export class Lp extends Product {
  artist: string;
  lpGenre: string;

  constructor(
    type: string,
    id?: number,
    title?: string,
    price?: number,
    artist?: string,
    lpGenre?: string) {
    super(type, id, title, price);
    this.artist = artist;
    this.lpGenre = lpGenre;
  }
}
