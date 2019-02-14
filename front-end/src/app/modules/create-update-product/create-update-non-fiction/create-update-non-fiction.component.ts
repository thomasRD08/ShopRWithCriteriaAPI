import {Component, OnInit} from '@angular/core';
import {NonFiction} from "../../../models/non-fiction";
import {NonFictionService} from "../../../services/non-fiction.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-create-non-fiction',
  templateUrl: './create-update-non-fiction.component.html',
  styleUrls: ['./create-update-non-fiction.component.scss']
})
export class CreateUpdateNonFictionComponent implements OnInit {
  nonFiction: NonFiction = new NonFiction();
  id: number;
  pending: boolean;

  constructor(private nonFictionService: NonFictionService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.nonFictionService.getNonFictionById(this.id).subscribe((data) => {
        this.nonFiction = data;
        this.pending = false;
      });
    } else {
      this.pending = false;
    }
  }

  confirm() {
    if (!this.id) {
      this.nonFictionService.createNonFiction(this.nonFiction).subscribe(() => this.router.navigate(['/products/books/non-fiction']))
    } else {
      this.nonFictionService.updateNonFitionById(this.id, this.nonFiction).subscribe(() => this.router.navigate(['/products/books/non-fiction']));
    }
  }
}
