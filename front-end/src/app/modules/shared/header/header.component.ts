import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from "../../../services/auth.service";
import {User} from "../../../models/user";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit, OnDestroy {
  user: User;
  private userSubscription: Subscription;

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
    this.getCurrentUser();
    this.userSubscription = this.authService.userSubject.subscribe(() => this.getCurrentUser());
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['']);
  }

  getCurrentUser() {
    this.user = this.authService.getCurrentUser();
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }
}
