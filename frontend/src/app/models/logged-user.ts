export class LoggedUser {
  static readonly LOGGED_USER_KEY = "logged_user";

  username: string;

  constructor(username: string) {
    this.username = username;
  }
}