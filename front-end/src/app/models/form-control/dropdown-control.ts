import {BaseControl} from "./base-control";

export class DropdownControl extends BaseControl<string> {
  controlType = 'dropdown';
  options: {value: string}[] = [];

  constructor(options: {} = {}) {
    super(options);
    this.options = options['options'] || [];
  }
}

