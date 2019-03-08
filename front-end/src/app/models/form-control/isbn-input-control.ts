import {BaseControl} from "./base-control";

export class IsbnInputControl extends BaseControl<string> {
  controlType = 'isbn';
  type: string;

  constructor(options: {} = {}) {
    super(options);
    this.type = options['type'] || '';
  }
}
