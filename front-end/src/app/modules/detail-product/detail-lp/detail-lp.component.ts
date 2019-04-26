import {Component, OnInit} from '@angular/core';
import {Lp} from "../../../models/products/lp";
import {ActivatedRoute, Router} from "@angular/router";
import {LpService} from "../../../services/lp.service";

@Component({
  selector: 'app-detail-lp',
  templateUrl: './detail-lp.component.html',
  styleUrls: ['./detail-lp.component.scss']
})
export class DetailLpComponent implements OnInit {
  lp: Lp;
  id: number;

  constructor(private lpService: LpService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
      this.lpService.getLpById(this.id).subscribe(data => this.lp = data);
    })
  }

  edit() {
    this.router.navigate([`/products/lp/${this.id}/edit`]);
  }

  delete() {
    this.lpService.deleteLpById(this.id).subscribe(() => this.router.navigate(['/products/lp']));
  }
}
