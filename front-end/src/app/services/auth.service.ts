import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";
import {Observable, Subject} from "rxjs";
import {GlobalConstant} from "../modules/shared/global-constant";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  userSubject = new Subject();

  constructor(private http: HttpClient) {
  }

  login(user: User): void {
    this.http.post<User>('/api/login', user).subscribe((user) => {
      localStorage.setItem(GlobalConstant.USER, JSON.stringify(user));
      this.userSubject.next();
    });
  }

  logout(): void {
    localStorage.removeItem(GlobalConstant.USER);
    this.userSubject.next();
  }

  register(user: User): Observable<User> {
    return this.http.post<User>('/api/register', user);
  }

  getCurrentUser(): User {
    return JSON.parse(localStorage.getItem(GlobalConstant.USER));
  }
}
