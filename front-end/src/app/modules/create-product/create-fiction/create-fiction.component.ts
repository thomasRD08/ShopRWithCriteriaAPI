import {Component, OnInit} from '@angular/core';
import {Fiction} from "../../../models/fiction";
import {FictionService} from "../../../services/fiction.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-fiction',
  templateUrl: './create-fiction.component.html',
  styleUrls: ['./create-fiction.component.scss']
})
export class CreateFictionComponent implements OnInit {
  fiction: Fiction = new Fiction();

  constructor(private fictionService: FictionService, private router: Router) { }

  ngOnInit() {
  }

  createFiction() {
    this.fictionService.createFiction(this.fiction).subscribe(() => this.router.navigate(['/products/books/fiction']))
  }
}
