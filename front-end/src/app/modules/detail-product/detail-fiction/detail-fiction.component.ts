import {Component, OnInit} from '@angular/core';
import {Fiction} from "../../../models/fiction";
import {FictionService} from "../../../services/fiction.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-detail-fiction',
  templateUrl: './detail-fiction.component.html',
  styleUrls: ['./detail-fiction.component.scss']
})
export class DetailFictionComponent implements OnInit {
  fiction: Fiction;
  id: number;

  constructor(private fictionService: FictionService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
      this.fictionService.getFictionById(this.id).subscribe(data => this.fiction = data);
    })
  }

  delete() {
    this.fictionService.deleteFictionById(this.id).subscribe(() => this.router.navigate(['/products/books/fiction']))
  }
}
