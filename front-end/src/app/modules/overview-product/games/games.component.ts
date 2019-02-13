import {AfterContentInit, Component, OnInit, ViewChild} from '@angular/core';
import {Game} from "../../../models/game";
import {GameService} from "../../../services/game.service";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.scss']
})
export class GamesComponent implements OnInit, AfterContentInit {
  displayedColumns: any[] = ['title', 'publisher', 'minAge', 'gameGenre', 'price', 'detail'];
  dataSource = new MatTableDataSource<Game>();

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private gameService: GameService, private router: Router) {
  }

  ngOnInit() {
    this.gameService.getGames().subscribe((data) => this.dataSource.data = data);
  }

  ngAfterContentInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  navigateToDetail(game: Game) {
    this.router.navigate([`/products/game/${game.id}`]);
  }
}
