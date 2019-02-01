import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";
import {Observable} from "rxjs";
import {GlobalConstant} from "../components/shared/global-constant";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) {
  }

  login(user: User): Observable<User> {
    return this.http.post<User>('/api/login', user);
  }

  logout(): void {
    sessionStorage.clear();
  }

  register(user: User): Observable<User> {
    return this.http.post<User>('/api/register', user);
  }

  getCurrentUser(): User {
    return JSON.parse(sessionStorage.getItem(GlobalConstant.USER));
  }
}
