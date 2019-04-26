import {BaseControl} from "./base-control";

export class PriceInputControl extends BaseControl<string> {
  controlType = 'price';
  type: string;

  constructor(options: {} = {}) {
    super(options);
    this.type = options['type'] || '';
  }
}
