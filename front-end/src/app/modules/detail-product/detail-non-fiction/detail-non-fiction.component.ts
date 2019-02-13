import {Component, OnInit} from '@angular/core';
import {NonFiction} from "../../../models/non-fiction";
import {NonFictionService} from "../../../services/non-fiction.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-detail-non-fiction',
  templateUrl: './detail-non-fiction.component.html',
  styleUrls: ['./detail-non-fiction.component.scss']
})
export class DetailNonFictionComponent implements OnInit {
  nonFiction: NonFiction;

  constructor(private nonFictionService: NonFictionService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      const id = params['id'];
      this.nonFictionService.getNonFictionById(id).subscribe(data => this.nonFiction = data);
    })
  }

}
