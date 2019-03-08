import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Lp} from "../models/products/lp";

@Injectable({
  providedIn: 'root'
})
export class LpService {
  constructor(private http: HttpClient) {
  }

  createLp(lp: Lp): Observable<Lp> {
    return this.http.post<Lp>('/api/products/lps', lp);
  }

  getLps(): Observable<Lp[]> {
    return this.http.get<Lp[]>('/api/products/lps');
  }

  getLpById(id: number): Observable<Lp> {
    return this.http.get<Lp>(`/api/products/lps/${id}`);
  }

  updateLpById(id: number, lp: Lp): Observable<Lp> {
    return this.http.put<Lp>(`/api/products/lps/${id}`, lp);
  }

  deleteLpById(id: number): Observable<any> {
    return this.http.delete<Lp>(`/api/products/lps/${id}`);
  }

  getLpGenreLabels(): Observable<string[]> {
    return this.http.get<string[]>('/api/products/lps/genres');
  }
}
