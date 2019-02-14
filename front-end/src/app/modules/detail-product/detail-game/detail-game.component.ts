import {Component, OnInit} from '@angular/core';
import {GameService} from "../../../services/game.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Game} from "../../../models/game";

@Component({
  selector: 'app-detail-game',
  templateUrl: './detail-game.component.html',
  styleUrls: ['./detail-game.component.scss']
})
export class DetailGameComponent implements OnInit {
  game: Game;
  id: number;

  constructor(private gameService: GameService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
      this.gameService.getGameById(this.id).subscribe(data => this.game = data);
    })
  }

  edit() {
    this.router.navigate([`/products/game/${this.id}/edit`]);
  }

  delete() {
    this.gameService.deleteGameById(this.id).subscribe(() => this.router.navigate(['/products/game']));
  }
}
