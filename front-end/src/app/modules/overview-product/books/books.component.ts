import {AfterContentInit, Component, OnInit, ViewChild} from '@angular/core';
import {Book} from "../../../models/book";
import {BookService} from "../../../services/book.service";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit, AfterContentInit {
  displayedColumns: any[] = ['type', 'title', 'author', 'isbn', 'pages', 'price', 'detail'];
  dataSource = new MatTableDataSource<Book>();

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private bookService: BookService, private router: Router) {
  }

  ngOnInit() {
    this.bookService.getBooks().subscribe((data) => this.dataSource.data = data);
  }

  ngAfterContentInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  navigateToDetail(book: Book) {
    if (book.type == 'Fiction') {
      this.router.navigate([`/products/books/fiction/${book.id}`]);
    } else if (book.type == 'Non-fiction') {
      this.router.navigate([`/products/books/non-fiction/${book.id}`])
    }
  }
}
