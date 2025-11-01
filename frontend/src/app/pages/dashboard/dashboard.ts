import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from '../../services/local-storage.service';
import { LoggedUser } from '../../models/logged-user';

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss',
})
export class Dashboard implements OnInit {

  username!: string;

  constructor(
    private _localStorageService: LocalStorageService
  ) {}

  ngOnInit(): void {
    const loggedUser = this._localStorageService.findByKey(LoggedUser.LOGGED_USER_KEY);
    this.username = loggedUser.username;
  }

}
