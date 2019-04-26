import {BaseControl} from "./base-control";

export class TextInputControl extends BaseControl<string>{
  controlType = 'text';
  type: string;

  constructor(options: {} = {}) {
    super(options);
    this.type = options['type'] || '';
  }
}
