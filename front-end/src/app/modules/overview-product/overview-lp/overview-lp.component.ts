import {AfterContentInit, Component, OnInit, ViewChild} from '@angular/core';
import {Lp} from "../../../models/products/lp";
import {LpService} from "../../../services/lp.service";
import {Router} from "@angular/router";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-lps',
  templateUrl: './overview-lp.component.html',
  styleUrls: ['./overview-lp.component.scss']
})
export class OverviewLpComponent implements OnInit, AfterContentInit {
  displayedColumns: any[] = ['title', 'artist', 'price', 'detail'];
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
