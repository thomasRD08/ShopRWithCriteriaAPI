import {Component, OnInit} from '@angular/core';
import {Fiction} from "../../../models/fiction";
import {FictionService} from "../../../services/fiction.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-detail-fiction',
  templateUrl: './detail-fiction.component.html',
  styleUrls: ['./detail-fiction.component.scss']
})
export class DetailFictionComponent implements OnInit {
  fiction: Fiction;

  constructor(private fictionService: FictionService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      const id = params['id'];
      this.fictionService.getFictionById(id).subscribe(data => this.fiction = data);
    })
  }

}
