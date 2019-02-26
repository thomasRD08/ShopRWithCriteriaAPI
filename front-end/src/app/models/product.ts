export abstract class Product {
  public id: number;
  public title: string;
  public price: number;

  protected constructor(public type: string) {
  }
}
