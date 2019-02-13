import {Component, OnInit} from '@angular/core';
import {Game} from "../../../models/game";
import {GameService} from "../../../services/game.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-game',
  templateUrl: './create-game.component.html',
  styleUrls: ['./create-game.component.scss']
})
export class CreateGameComponent implements OnInit {
  game: Game = new Game();

  constructor(private gameService: GameService, private router: Router) {
  }

  ngOnInit() {
  }

  createGame() {
    this.gameService.createGame(this.game).subscribe(() => this.router.navigate(['/products/game']))
  }
}
