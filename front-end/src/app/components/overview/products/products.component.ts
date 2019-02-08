import {Component, OnInit} from '@angular/core';
import {Product} from "../../../models/product";
import {ProductService} from "../../../services/product.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  products: Product[];
  product: Product;
  displayedColumns: any[] = ['type', 'title', 'price'];

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.getProducts().subscribe((data) => this.products = data);
  }
}
