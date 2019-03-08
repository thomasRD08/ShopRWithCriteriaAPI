import {Component, OnInit} from '@angular/core';
import {NonFiction} from "../../../models/products/non-fiction";
import {NonFictionService} from "../../../services/non-fiction.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-create-non-fiction',
  templateUrl: './create-update-non-fiction.component.html',
  styleUrls: ['./create-update-non-fiction.component.scss']
})
export class CreateUpdateNonFictionComponent implements OnInit {
  nonFiction: NonFiction = new NonFiction('Non-fiction');
  id: number;
  pending: boolean;
  subjects: string[];

  constructor(private nonFictionService: NonFictionService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.nonFictionService.getNonFictionSubjectLabels().subscribe((data) => this.subjects = data);
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
      this.nonFictionService.updateNonFictionById(this.id, this.nonFiction).subscribe(() => this.router.navigate(['/products/books/non-fiction']));
    }
  }
}
