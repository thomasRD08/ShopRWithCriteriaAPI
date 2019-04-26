import {Injectable} from '@angular/core';
import {BaseControl} from "../../models/form-control/base-control";
import {TextInputControl} from "../../models/form-control/text-input-control";
import {DropdownControl} from "../../models/form-control/dropdown-control";
import {Validators} from "@angular/forms";
import {TextareaInputControl} from "../../models/form-control/textarea-input-control";
import {PriceInputControl} from "../../models/form-control/price-input-control";
import {IsbnInputControl} from "../../models/form-control/isbn-input-control";

@Injectable({
  providedIn: 'root'
})
export class FormFactoryService {
  constructor() {
  }

  getLpForm(genres: string[]) {
    let formControls: BaseControl<any>[] = [
      new TextInputControl({
        key: 'title',
        label: 'Title',
        placeholder: 'e.g. "Paranoid"',
        order: 1,
        type: 'text',
        validators: [
          Validators.required,
          Validators.maxLength(50)
        ]
      }),
      new TextInputControl({
        key: 'artist',
        label: 'Artist',
        placeholder: 'e.g. "Black Sabbath"',
        order: 2,
        type: 'text',
        validators: [
          Validators.required,
          Validators.maxLength(50)
        ]
      }),
      new DropdownControl({
        key: 'genre',
        label: 'Genre',
        order: 3,
        options: genres,
        validators: [
          Validators.required,
        ]
      }),
      new PriceInputControl({
        key: 'price',
        label: 'Price',
        placeholder: 'e.g. "14.99"',
        order: 4,
        type: 'text',
        validators: [
          Validators.required,
          Validators.pattern('^([1-9][0-9]{0,3}([\.,][0-9]{2})?|0{1}[\.,][0-9][1-9]|0{1}[\.,][1-9][0-9])?$')
        ]
      })
    ];
    return formControls.sort((a, b) => a.order - b.order);
  }

  getGameForm(genres: string[], minAges: string[]) {
    let formControls: BaseControl<any>[] = [
      new TextInputControl({
        key: 'title',
        label: 'Title',
        placeholder: 'e.g. "Minecraft"',
        order: 1,
        type: 'text',
        validators: [
          Validators.required,
          Validators.maxLength(50)
        ]
      }),
      new TextInputControl({
        key: 'publisher',
        label: 'Publisher',
        placeholder: 'e.g. "Mojang"',
        order: 2,
        type: 'text',
        validators: [
          Validators.required,
          Validators.maxLength(50)
        ]
      }),
      new DropdownControl({
        key: 'minAge',
        label: 'Minimum age',
        order: 3,
        options: minAges,
        validators: [
          Validators.required,
        ]
      }),
      new DropdownControl({
        key: 'genre',
        label: 'Genre',
        order: 4,
        options: genres,
        validators: [
          Validators.required,
        ]
      }),
      new PriceInputControl({
        key: 'price',
        label: 'Price',
        placeholder: 'e.g. "19.99"',
        order: 5,
        type: 'text',
        validators: [
          Validators.required,
          Validators.pattern('^([1-9][0-9]{0,3}([\.,][0-9]{2})?|0{1}[\.,][0-9][1-9]|0{1}[\.,][1-9][0-9])?$')
        ]
      })
    ];
    return formControls.sort((a, b) => a.order - b.order);
  }

  getFictionForm(genres: string[]) {
    let formControls: BaseControl<any>[] = [
      new TextInputControl({
        key: 'title',
        label: 'Title',
        placeholder: 'e.g. "The Kite Runner"',
        order: 1,
        type: 'text',
        validators: [
          Validators.required,
          Validators.maxLength(50)
        ]
      }),
      new TextInputControl({
        key: 'author',
        label: 'Author',
        placeholder: 'e.g. "Khaled Hosseini"',
        order: 2,
        type: 'text',
        validators: [
          Validators.required,
          Validators.maxLength(50)
        ]
      }),
      new IsbnInputControl({
        key: 'isbn',
        label: 'ISBN',
        placeholder: 'e.g. "978-161-729-045-9"',
        order: 3,
        type: 'text',
        validators: [
          Validators.required,
          Validators.pattern('^(97(8|9))?[0-9]{9}([0-9]|X)$')
        ]
      }),
      new TextInputControl({
        key: 'pages',
        label: 'Pages',
        placeholder: 'e.g. "371"',
        order: 4,
        type: 'text',
        validators: [
          Validators.required,
          Validators.pattern('^[0-9]{1,99999}$')
        ]
      }),
      new DropdownControl({
        key: 'genre',
        label: 'Genre',
        order: 5,
        options: genres,
        validators: [
          Validators.required
        ]
      }),
      new TextareaInputControl({
        key: 'summary',
        label: 'Summary',
        placeholder: 'e.g. "A sweeping story of family, love, and friendship told against the devastating backdrop ' +
          'of the history of Afghanistan over the last thirty years. The Kite Runner is an unusual and powerful novel ' +
          'that has become a beloved, one-of-a-kind classic."',
        order: 6,
        type: 'text',
        validators: [
          Validators.required,
          Validators.maxLength(500)
        ]
      }),
      new PriceInputControl({
        key: 'price',
        label: 'Price',
        placeholder: 'e.g. "12.00"',
        order: 7,
        type: 'text',
        validators: [
          Validators.required,
          Validators.pattern('^([1-9][0-9]{0,3}([\.,][0-9]{2})?|0{1}[\.,][0-9][1-9]|0{1}[\.,][1-9][0-9])?$')
        ]
      })
    ];
    return formControls.sort((a, b) => a.order - b.order);
  }

  getNonFictionForm(subjects: string[]) {
    let formControls: BaseControl<any>[] = [
      new TextInputControl({
        key: 'title',
        label: 'Title',
        placeholder: 'e.g. "The Oxford History of Ancient Egypt"',
        order: 1,
        type: 'text',
        validators: [
          Validators.required,
          Validators.maxLength(50)
        ]
      }),
      new TextInputControl({
        key: 'author',
        label: 'Author',
        placeholder: 'e.g. "Ian Shaw"',
        order: 2,
        type: 'text',
        validators: [
          Validators.required,
          Validators.maxLength(50)
        ]
      }),
      new IsbnInputControl({
        key: 'isbn',
        label: 'ISBN',
        placeholder: 'e.g. "978-161-729-045-9"',
        order: 3,
        type: 'text',
        validators: [
          Validators.required,
          Validators.pattern('^(97(8|9))?[0-9]{9}([0-9]|X)$')
        ]
      }),
      new TextInputControl({
        key: 'pages',
        label: 'Pages',
        placeholder: 'e.g. "554"',
        order: 4,
        type: 'text',
        validators: [
          Validators.required,
          Validators.pattern('^[0-9]{1,99999}$')
        ]
      }),
      new DropdownControl({
        key: 'subject',
        label: 'Subject',
        order: 5,
        options: subjects,
        validators: [
          Validators.required
        ]
      }),
      new PriceInputControl({
        key: 'price',
        label: 'Price',
        placeholder: 'e.g. "14.95"',
        order: 6,
        type: 'text',
        validators: [
          Validators.required,
          Validators.pattern('^([1-9][0-9]{0,3}([\.,][0-9]{2})?|0{1}[\.,][0-9][1-9]|0{1}[\.,][1-9][0-9])?$')
        ]
      })
    ];
    return formControls.sort((a, b) => a.order - b.order);
  }
}
