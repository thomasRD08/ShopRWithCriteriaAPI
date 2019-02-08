import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductsComponent} from "./products/products.component";
import {SharedModule} from "../shared/shared.module";
import {ProductService} from "../../services/product.service";
import {BooksComponent} from './books/books.component';
import {BookService} from "../../services/book.service";
import {LpsComponent} from './lps/lps.component';
import {GamesComponent} from './games/games.component';
import {LpService} from "../../services/lp.service";
import {GameService} from "../../services/game.service";
import {FictionService} from "../../services/fiction.service";
import {NonFictionService} from "../../services/non-fiction.service";
import {FictionComponent} from './fiction/fiction.component';
import {NonFictionComponent} from './non-fiction/non-fiction.component';

@NgModule({
  declarations: [
    ProductsComponent,
    BooksComponent,
    LpsComponent,
    GamesComponent,
    FictionComponent,
    NonFictionComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    ProductsComponent,
    BooksComponent,
    LpsComponent,
    GamesComponent,
    FictionComponent,
    NonFictionComponent
  ],
  providers: [
    ProductService,
    BookService,
    LpService,
    GameService,
    FictionService,
    NonFictionService
  ]
})
export class OverviewModule {
}
