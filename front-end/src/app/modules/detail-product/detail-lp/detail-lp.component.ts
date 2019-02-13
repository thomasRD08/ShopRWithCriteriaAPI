import {Component, OnInit} from '@angular/core';
import {Lp} from "../../../models/lp";
import {ActivatedRoute} from "@angular/router";
import {LpService} from "../../../services/lp.service";

@Component({
  selector: 'app-detail-lp',
  templateUrl: './detail-lp.component.html',
  styleUrls: ['./detail-lp.component.scss']
})
export class DetailLpComponent implements OnInit {
  lp: Lp;

  constructor(private lpService: LpService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      const id = params['id'];
      this.lpService.getLpById(id).subscribe(data => this.lp = data);
    })
  }
}
