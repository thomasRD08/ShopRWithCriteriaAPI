import {Component, OnInit} from '@angular/core';
import {Game} from "../../../models/products/game";
import {GameService} from "../../../services/game.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-create-game',
  templateUrl: './create-update-game.component.html',
  styleUrls: ['./create-update-game.component.scss']
})
export class CreateUpdateGameComponent implements OnInit {
  game: Game = new Game('Game');
  id: number;
  pending: boolean;
  genres: string[];
  minAges: string[];

  constructor(private gameService: GameService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.gameService.getGameGenreLabels().subscribe((data) => this.genres = data);
    this.gameService.getGameMinAgeLabels().subscribe((data) => this.minAges = data);
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
