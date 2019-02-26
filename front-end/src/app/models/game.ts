import {Product} from "./product";

export class Game extends Product{
  public publisher: string;
  public gameMinAge: string;
  public gameGenre: string;

  constructor(public type: string) {
    super(type);
  }
}
