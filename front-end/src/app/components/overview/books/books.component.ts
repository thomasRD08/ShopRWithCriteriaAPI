import {Component, OnInit} from '@angular/core';
import {Book} from "../../../models/book";
import {BookService} from "../../../services/book.service";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {
  books: Book[];
  book: Book;
  displayedColumns: any[] = ['title', 'author', 'isbn', 'pages', 'price'];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.bookService.getBooks().subscribe((data) => this.books = data);
  }
}
