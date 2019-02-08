import {Component, OnInit} from '@angular/core';
import {Game} from "../../../models/game";
import {GameService} from "../../../services/game.service";

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.scss']
})
export class GamesComponent implements OnInit {
  games: Game[];
  game: Game;
  displayedColumns: any[] = ['title', 'publisher', 'minAge', 'gameGenre', 'price'];

  constructor(private gameService: GameService) { }

  ngOnInit() {
    this.gameService.getGames().subscribe((data) => this.games = data);
  }
}
