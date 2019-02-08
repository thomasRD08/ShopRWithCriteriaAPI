import {Component, OnInit} from '@angular/core';
import {LpService} from "../../../services/lp.service";
import {Lp} from "../../../models/lp";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-lp',
  templateUrl: './create-lp.component.html',
  styleUrls: ['./create-lp.component.scss']
})
export class CreateLpComponent implements OnInit {
  lp: Lp = new Lp();

  constructor(private lpService: LpService, private router: Router) { }

  ngOnInit() {
  }

  createLp() {
    this.lpService.createLp(this.lp).subscribe(() => this.router.navigate(['/overview/products/lps']));
  }
}
