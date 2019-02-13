import {AfterContentInit, Component, OnInit, ViewChild} from '@angular/core';
import {Lp} from "../../../models/lp";
import {LpService} from "../../../services/lp.service";
import {Router} from "@angular/router";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-lps',
  templateUrl: './lps.component.html',
  styleUrls: ['./lps.component.scss']
})
export class LpsComponent implements OnInit, AfterContentInit {
  displayedColumns: any[] = ['title', 'artist', 'lpGenre', 'price', 'detail'];
  dataSource = new MatTableDataSource<Lp>();

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private lpService: LpService, private router: Router) {
  }

  ngOnInit() {
    this.lpService.getLps().subscribe((data) => this.dataSource.data = data);
  }

  ngAfterContentInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  navigateToDetail(lp: Lp) {
    this.router.navigate([`/products/lp/${lp.id}`]);
  }
}
