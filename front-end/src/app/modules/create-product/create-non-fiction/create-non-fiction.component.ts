import {Component, OnInit} from '@angular/core';
import {NonFiction} from "../../../models/non-fiction";
import {NonFictionService} from "../../../services/non-fiction.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-non-fiction',
  templateUrl: './create-non-fiction.component.html',
  styleUrls: ['./create-non-fiction.component.scss']
})
export class CreateNonFictionComponent implements OnInit {
  nonFiction: NonFiction = new NonFiction();

  constructor(private nonFictionService: NonFictionService, private router: Router) { }

  ngOnInit() {
  }

  createNonFiction() {
    this.nonFictionService.createNonFiction(this.nonFiction).subscribe(() => this.router.navigate(['/products/books/non-fiction']))
  }
}
