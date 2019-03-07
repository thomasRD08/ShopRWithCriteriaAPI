import {Injectable} from '@angular/core';
import {BaseControl} from "../../models/form-control/base-control";
import {TextInputControl} from "../../models/form-control/text-input-control";
import {DropdownControl} from "../../models/form-control/dropdown-control";
import {PriceInputControl} from "../../models/form-control/price-input-control";

@Injectable({
  providedIn: 'root'
})
export class FormFactoryService {
  constructor() {
  }

  getLpForm() {
    let formControls: BaseControl<any>[] = [
      new TextInputControl({
        key: 'title',
        label: 'Title',
        placeholder: 'e.g. "Paranoid"',
        required: true,
        order: 1,
        type: 'text'
      }),
      new TextInputControl({
        key: 'artist',
        label: 'Artist',
        placeholder: 'e.g. "Black Sabbath"',
        required: true,
        order: 2,
        type: 'text'
      }),
      new DropdownControl({
        key: 'genre',
        label: 'Genre',
        required: true,
        order: 3,
        options: []
      }),
      new PriceInputControl({
        key: 'price',
        label: 'Price',
        placeholder: 'e.g. "14.99"',
        required: true,
        order: 4,
        type: 'number'
      })
    ];
    return formControls.sort((a, b) => a.order - b.order);
  }

  getGameForm() {
    let formControls: BaseControl<any>[] = [
      new TextInputControl({
        key: 'title',
        label: 'Title',
        placeholder: 'e.g. "Minecraft"',
        required: true,
        order: 1,
        type: 'text'
      }),
      new TextInputControl({
        key: 'publisher',
        label: 'Publisher',
        placeholder: 'e.g. "Mojang"',
        required: true,
        order: 2,
        type: 'text'
      }),
      new DropdownControl({
        key: 'minAge',
        label: 'Minimum age',
        required: true,
        order: 3,
        options: []
      }),
      new DropdownControl({
        key: 'genre',
        label: 'Genre',
        required: true,
        order: 4,
        options: []
      }),
      new PriceInputControl({
        key: 'price',
        label: 'Price',
        placeholder: 'e.g. "19.99"',
        required: true,
        order: 5,
        type: 'number'
      })
    ];
    return formControls.sort((a, b) => a.order - b.order);
  }

  getFictionForm() {
    let formControls: BaseControl<any>[] = [
      new TextInputControl({
        key: 'title',
        label: 'Title',
        placeholder: 'e.g. "The Kite Runner"',
        required: true,
        order: 1,
        type: 'text'
      }),
      new TextInputControl({
        key: 'author',
        label: 'Author',
        placeholder: 'e.g. "Khaled Hosseini"',
        required: true,
        order: 2,
        type: 'text'
      })
    ];
    return formControls.sort((a, b) => a.order - b.order);
  }

  getNonFictionForm() {
    let formControls: BaseControl<any>[] = [
      new TextInputControl({
        key: 'title',
        label: 'Title',
        placeholder: 'Title',
        required: true,
        order: 1,
        type: 'text'
      })
    ];
    return formControls.sort((a, b) => a.order - b.order);
  }
}
