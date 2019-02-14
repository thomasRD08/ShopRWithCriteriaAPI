import {Component, OnInit} from '@angular/core';
import {Fiction} from "../../../models/fiction";
import {FictionService} from "../../../services/fiction.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-create-fiction',
  templateUrl: './create-fiction.component.html',
  styleUrls: ['./create-fiction.component.scss']
})
export class CreateFictionComponent implements OnInit {
  fiction: Fiction = new Fiction();
  id: number;
  pending: boolean;

  constructor(private fictionService: FictionService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.fictionService.getFictionById(this.id).subscribe((data) => {
        this.fiction = data;
        this.pending = false;
      });
    } else {
      this.pending = false;
    }
  }

  confirm() {
    if (!this.id) {
      this.fictionService.createFiction(this.fiction).subscribe(() => this.router.navigate(['/products/books/fiction']))
    } else {
      this.fictionService.updateFictionById(this.id, this.fiction).subscribe(() => this.router.navigate(['/products/books/fiction']));
    }
  }
}
