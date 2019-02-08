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

  getFiction(): Observable<Fiction[]> {
    return this.http.get<Fiction[]>('/api/products/books/fiction')
  }
}
