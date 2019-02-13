import {AfterContentInit, Component, OnInit, ViewChild} from '@angular/core';
import {NonFiction} from "../../../models/non-fiction";
import {NonFictionService} from "../../../services/non-fiction.service";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";

@Component({
  selector: 'app-non-fiction',
  templateUrl: './non-fiction.component.html',
  styleUrls: ['./non-fiction.component.scss']
})
export class NonFictionComponent implements OnInit, AfterContentInit {
  displayedColumns: any[] = ['title', 'author', 'isbn', 'pages', 'nonFictionSubject', 'price', 'detail'];
  dataSource = new MatTableDataSource<NonFiction>();

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private nonFictionService: NonFictionService, private router: Router) {
  }

  ngOnInit() {
    this.nonFictionService.getNonFiction().subscribe((data) => this.dataSource.data = data);
  }

  ngAfterContentInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  navigateToDetail(nonFiction: NonFiction) {
    this.router.navigate([`/products/books/non-fiction/${nonFiction.id}`]);
  }
}
