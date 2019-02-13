import {AfterContentInit, Component, OnInit, ViewChild} from '@angular/core';
import {Fiction} from "../../../models/fiction";
import {FictionService} from "../../../services/fiction.service";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";

@Component({
  selector: 'app-fiction',
  templateUrl: './fiction.component.html',
  styleUrls: ['./fiction.component.scss']
})
export class FictionComponent implements OnInit, AfterContentInit {
  displayedColumns: any[] = ['title', 'author', 'isbn', 'pages', 'fictionGenre', 'summary', 'price', 'detail'];
  dataSource = new MatTableDataSource<Fiction>();

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private fictionService: FictionService, private router: Router) {
  }

  ngOnInit() {
    this.fictionService.getFiction().subscribe((data) => this.dataSource.data = data);
  }

  ngAfterContentInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  navigateToDetail(fiction: Fiction) {
    this.router.navigate([`/products/books/fiction/${fiction.id}`]);
  }
}
