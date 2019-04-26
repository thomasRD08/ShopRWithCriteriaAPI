import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {
  }

  getUserByUsername(username: string): Observable<User> {
    return this.http.get<User>(`/api/users/${username}`);
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users');
  }
}
