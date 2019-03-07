import {Injectable} from '@angular/core';
import {BaseControl} from "../../models/form-control/base-control";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class FormControlService {
  constructor() {
  }

  toFormGroup(inputFields: BaseControl<any>[]) {
    let group: any = {};

    inputFields.forEach(inputField => {
      group[inputField.key] = inputField.required
        ? new FormControl(inputField.value || '', Validators.required)
        : new FormControl(inputField.value || '');
    });
    return new FormGroup(group);
  }
}
