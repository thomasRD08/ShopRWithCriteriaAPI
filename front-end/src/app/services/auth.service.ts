import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";
import {ObjectUnsubscribedError, Observable, Subject} from "rxjs";
import {GlobalConstant} from "../components/shared/global-constant";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  userSubject = new Subject();

  constructor(private http: HttpClient) {
  }

  login(user: User): void {
    this.http.post<User>('/api/login', user).subscribe((user) => {
      sessionStorage.setItem(GlobalConstant.USER, JSON.stringify(user));
      this.userSubject.next();
    });
  }

  logout(): void {
    sessionStorage.clear();
    this.userSubject.next();
  }

  register(user: User): Observable<User> {
    return this.http.post<User>('/api/register', user);
  }

  getCurrentUser(): User {
    return JSON.parse(sessionStorage.getItem(GlobalConstant.USER));
  }
}
