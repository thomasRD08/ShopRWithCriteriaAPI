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

  createNonFiction(nonFiction: NonFiction): Observable<NonFiction> {
    return this.http.post<NonFiction>('/api/products/books/non-fiction', nonFiction);
  }

  getNonFiction(): Observable<NonFiction[]> {
    return this.http.get<NonFiction[]>('/api/products/books/non-fiction');
  }

  getNonFictionById(id: number): Observable<NonFiction> {
    return this.http.get<NonFiction>(`/api/products/books/non-fiction/${id}`);
  }

  deleteNonFictionById(id: number): Observable<any> {
    return this.http.delete<NonFiction>(`/api/products/books/non-fiction/${id}`);
  }
}
