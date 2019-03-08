import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {FormControlService} from "../../../services/dynamic-form/form-control.service";
import {BaseControl} from "../../../models/form-control/base-control";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-dynamic-form',
  templateUrl: './dynamic-form.component.html',
  styleUrls: ['./dynamic-form.component.scss'],
  providers: [FormControlService]
})
export class DynamicFormComponent implements OnInit, OnChanges {
  @Input() controls: BaseControl<any>[] = [];
  form: FormGroup;
  payLoad = '';

  constructor(private fcs: FormControlService) {
  }

  ngOnInit() {
    this.form = this.fcs.toFormGroup(this.controls);
  }

  ngOnChanges(changes: SimpleChanges): void {

    this.form = this.fcs.toFormGroup(this.controls);
  }

  onSubmit() {
    this.payLoad = JSON.stringify(this.form.value);
  }


}
