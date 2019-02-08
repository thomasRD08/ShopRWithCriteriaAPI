import {Component, OnInit} from '@angular/core';
import {Fiction} from "../../../models/fiction";
import {FictionService} from "../../../services/fiction.service";

@Component({
  selector: 'app-fiction',
  templateUrl: './fiction.component.html',
  styleUrls: ['./fiction.component.scss']
})
export class FictionComponent implements OnInit {
  fictions: Fiction[];
  fiction: Fiction;
  displayedColumns: any[] = ['title', 'author', 'isbn', 'pages', 'fictionGenre', 'summary', 'price'];

  constructor(private fictionService: FictionService) { }

  ngOnInit() {
    this.fictionService.getFiction().subscribe((data) => this.fictions = data);
  }
}
