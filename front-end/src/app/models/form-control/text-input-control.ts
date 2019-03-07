import {BaseControl} from "./base-control";

export class TextInputControl extends BaseControl<string>{
  controlType = 'string';
  type: string;

  constructor(options: {} = {}) {
    super(options);
    this.type = options['type'] || '';
  }
}
