import {Component, OnInit} from '@angular/core';
import {GameService} from "../../../services/game.service";
import {ActivatedRoute} from "@angular/router";
import {Game} from "../../../models/game";

@Component({
  selector: 'app-detail-game',
  templateUrl: './detail-game.component.html',
  styleUrls: ['./detail-game.component.scss']
})
export class DetailGameComponent implements OnInit {
  game: Game;

  constructor(private gameService: GameService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      const id = params['id'];
      this.gameService.getGameById(id).subscribe(data => this.game = data);
    })
  }

}
