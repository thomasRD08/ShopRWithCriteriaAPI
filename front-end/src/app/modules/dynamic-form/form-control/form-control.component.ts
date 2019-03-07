import {Component, Input, OnInit} from '@angular/core';
import {BaseControl} from "../../../models/form-control/base-control";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-form-control',
  templateUrl: './form-control.component.html',
  styleUrls: ['./form-control.component.scss']
})
export class FormControlComponent implements OnInit {
  @Input() control: BaseControl<any>;
  @Input() form: FormGroup;

  constructor() { }

  ngOnInit() {
  }

  get isValid() {
    return this.form.controls[this.control.key].valid;
  }
}
