export abstract class Product {
  type: string;
  id: number;
  title: string;
  price: number;

  protected constructor(
    type: string,
    id?: number,
    title?: string,
    price?: number) {
    this.type = type;
    this.id = id;
    this.title = title;
    this.price = price;
  }
}
