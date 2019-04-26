import {BaseControl} from "./base-control";

export class TextareaInputControl extends BaseControl<string> {
  controlType = 'textarea';
  type: string;

  constructor(options: {} = {}) {
    super(options);
    this.type = options['type'] || '';
  }
}
