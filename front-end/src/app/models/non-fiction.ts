import {Book} from "./book";

export class NonFiction extends Book{
  public nonFictionSubject: string;

  constructor(public type: string) {
    super(type);
  }
}
