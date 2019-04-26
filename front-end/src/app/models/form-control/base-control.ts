import {ValidatorFn} from "@angular/forms";

export abstract class BaseControl<T> {
  value: T;
  key: string;
  label: string;
  placeholder: string;
  order: number;
  controlType: string;
  validators: ValidatorFn[];

  protected constructor(options: {
    value?: T,
    key?: string,
    label?: string,
    placeholder?: string,
    order?: number,
    controlType?: string,
    validators?: ValidatorFn[]
  } = {}) {
    this.value = options.value;
    this.key = options.key || '';
    this.label = options.label || '';
    this.placeholder = options.placeholder || '';
    this.order = options.order === undefined ? 1: options.order;
    this.controlType = options.controlType || '';
    this.validators = options.validators || [];
  }

  // get required(): boolean {
  //   return this.validators.filter(Validators.required());
  // }
}
