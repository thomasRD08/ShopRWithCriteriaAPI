import {AfterContentInit, Component, OnInit, ViewChild} from '@angular/core';
import {Product} from "../../../models/product";
import {ProductService} from "../../../services/product.service";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";
import {Lp} from "../../../models/lp";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit, AfterContentInit {
  displayedColumns: any[] = ['type', 'title', 'price', 'detail'];
  dataSource = new MatTableDataSource<Product>();

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private productService: ProductService, private router: Router) {
  }

  ngOnInit() {
    this.productService.getProducts().subscribe((data) => this.dataSource.data = data);
  }

  ngAfterContentInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  navigateToDetail(product: Product) {
    if (product.type == 'Lp') {
      this.router.navigate([`/products/lp/${product.id}`]);
    } else if (product.type == 'Game') {
      this.router.navigate([`/products/game/${product.id}`]);
    } else if (product.type == 'Fiction') {
      this.router.navigate([`/products/books/fiction/${product.id}`]);
    } else if (product.type == 'Non-fiction') {
      this.router.navigate([`/products/books/non-fiction/${product.id}`]);
    }
  }
}
