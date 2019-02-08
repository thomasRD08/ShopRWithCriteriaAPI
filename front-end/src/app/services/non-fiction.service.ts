import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {NonFiction} from "../models/non-fiction";

@Injectable({
  providedIn: 'root'
})
export class NonFictionService {
  constructor(private http: HttpClient) {
  }

  getNonFiction(): Observable<NonFiction[]> {
    return this.http.get<NonFiction[]>('/api/products/books/non-fiction');
  }
}
