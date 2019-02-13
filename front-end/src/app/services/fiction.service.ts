import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Fiction} from "../models/fiction";

@Injectable({
  providedIn: 'root'
})
export class FictionService {
  constructor(private http: HttpClient) {
  }

  createFiction(fiction: Fiction): Observable<Fiction> {
    return this.http.post<Fiction>('/api/products/books/fiction', fiction);
  }

  getFiction(): Observable<Fiction[]> {
    return this.http.get<Fiction[]>('/api/products/books/fiction')
  }

  getFictionById(id: number): Observable<Fiction> {
    return this.http.get<Fiction>(`/api/products/books/fiction/${id}`);
  }
}
