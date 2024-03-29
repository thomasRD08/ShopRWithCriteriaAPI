import {Component, OnInit} from '@angular/core';
import {User} from "../../../models/user";
import {UserService} from "../../../services/user.service";
import {AuthService} from "../../../services/auth.service";
import {Location} from "@angular/common";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  users: User[];
  selectedUser: User;

  constructor(private userService: UserService, private authService: AuthService, private location: Location) {
  }

  ngOnInit() {
    this.userService.getUsers().subscribe((data) => this.users = data);
  }

  login() {
    this.authService.login(this.selectedUser);
    this.location.back();
  }
}
