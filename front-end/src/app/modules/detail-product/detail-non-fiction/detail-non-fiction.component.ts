import {Component, OnInit} from '@angular/core';
import {NonFiction} from "../../../models/products/non-fiction";
import {NonFictionService} from "../../../services/non-fiction.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-detail-non-fiction',
  templateUrl: './detail-non-fiction.component.html',
  styleUrls: ['./detail-non-fiction.component.scss']
})
export class DetailNonFictionComponent implements OnInit {
  nonFiction: NonFiction;
  id: number;

  constructor(private nonFictionService: NonFictionService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
      this.nonFictionService.getNonFictionById(this.id).subscribe(data => this.nonFiction = data);
    })
  }

  edit() {
    this.router.navigate([`/products/books/non-fiction/${this.id}/edit`]);
  }

  delete() {
    this.nonFictionService.deleteNonFictionById(this.id).subscribe(() => this.router.navigate(['/products/books/non-fiction']));
  }
}
