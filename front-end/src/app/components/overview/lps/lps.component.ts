import {Component, OnInit} from '@angular/core';
import {Lp} from "../../../models/lp";
import {LpService} from "../../../services/lp.service";

@Component({
  selector: 'app-lps',
  templateUrl: './lps.component.html',
  styleUrls: ['./lps.component.scss']
})
export class LpsComponent implements OnInit {
  lps: Lp[];
  lp: Lp;
  displayedColumns: any[] = ['title', 'artist', 'lpGenre', 'price'];

  constructor(private lpService: LpService) { }

  ngOnInit() {
    this.lpService.getLps().subscribe((data) => this.lps = data);
  }
}
