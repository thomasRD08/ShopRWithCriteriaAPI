import {Injectable} from '@angular/core';
import {BaseControl} from "../../models/form-control/base-control";
import {FormControl, FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class FormControlService {
  constructor() {
  }

  toFormGroup(inputFields: BaseControl<any>[]) {
    let group: any = {};

    if (inputFields !== undefined) {
      inputFields.forEach(inputField => {
        group[inputField.key] = new FormControl(inputField.value || '', inputField.validators);
      });
    }
    return new FormGroup(group);
  }
}
