import {Component, OnInit} from '@angular/core';
import {NonFiction} from "../../../models/non-fiction";
import {NonFictionService} from "../../../services/non-fiction.service";

@Component({
  selector: 'app-non-fiction',
  templateUrl: './non-fiction.component.html',
  styleUrls: ['./non-fiction.component.scss']
})
export class NonFictionComponent implements OnInit {
  nonFictions: NonFiction[];
  nonFiction: NonFiction;
  displayedColumns: any[] = ['title', 'author', 'isbn', 'pages', 'nonFictionSubject', 'price'];

  constructor(private nonFictionService: NonFictionService) { }

  ngOnInit() {
    this.nonFictionService.getNonFiction().subscribe((data) => this.nonFictions = data);
  }
}
