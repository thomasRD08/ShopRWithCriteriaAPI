import {Component, OnInit} from '@angular/core';
import {LpService} from "../../../services/lp.service";
import {Lp} from "../../../models/products/lp";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-create-lp',
  templateUrl: './create-update-lp.component.html',
  styleUrls: ['./create-update-lp.component.scss']
})
export class CreateUpdateLpComponent implements OnInit {
  lp: Lp = new Lp('Lp');
  id: number;
  pending: boolean;
  genres: string[];

  constructor(private lpService: LpService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.lpService.getLpGenreLabels().subscribe((data) => this.genres = data);
    this.id = +this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.lpService.getLpById(this.id).subscribe((data) => {
        this.lp = data;
        this.pending = false;
      });
    } else {
      this.pending = false;
    }
  }

  confirm() {
    if (!this.id) {
      this.lpService.createLp(this.lp).subscribe(() => this.router.navigate(['/products/lp']));
    } else {
      this.lpService.updateLpById(this.id, this.lp).subscribe(() => this.router.navigate(['/products/lp']));
    }
  }
}
