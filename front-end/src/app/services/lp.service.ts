import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Lp} from "../models/lp";

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

  deleteLpById(id: number): Observable<any> {
    return this.http.delete<Lp>(`/api/products/lps/${id}`);
  }
}
