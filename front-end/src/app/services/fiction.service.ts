import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Fiction} from "../models/products/fiction";

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

  updateFictionById(id: number, fiction: Fiction): Observable<Fiction> {
    return this.http.put<Fiction>(`/api/products/books/fiction/${id}`, fiction);
  }

  deleteFictionById(id: number): Observable<any> {
    return this.http.delete<Fiction>(`/api/products/books/fiction/${id}`);
  }

  getFictionGenreLabels(): Observable<string[]> {
    return this.http.get<string[]>('/api/products/books/fiction/genres')
  }
}
