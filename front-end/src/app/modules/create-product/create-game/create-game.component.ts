import {Component, OnInit} from '@angular/core';
import {Game} from "../../../models/game";
import {GameService} from "../../../services/game.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-create-game',
  templateUrl: './create-game.component.html',
  styleUrls: ['./create-game.component.scss']
})
export class CreateGameComponent implements OnInit {
  game: Game = new Game();
  id: number;
  pending: boolean;

  constructor(private gameService: GameService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.gameService.getGameById(this.id).subscribe((data) => {
        this.game = data;
        this.pending = false;
      });
    } else {
      this.pending = false;
    }
  }

  confirm() {
    if (!this.id) {
      this.gameService.createGame(this.game).subscribe(() => this.router.navigate(['/products/game']));
    } else {
      this.gameService.updateGameById(this.id, this.game).subscribe(() => this.router.navigate(['/products/game']));
    }
  }
}
