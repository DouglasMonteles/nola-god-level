import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { LocalStorageService } from '../services/local-storage.service';
import { LoggedUser } from '../models/logged-user';

export const redirectToLoginGuard: CanActivateFn = (route, state) => {
  const localStorageService = inject(LocalStorageService);
  const router = inject(Router);

  const userAlreadyLogged: () => boolean = () => {
    return localStorageService.findByKey(LoggedUser.LOGGED_USER_KEY) != null;
  }

  if (!userAlreadyLogged()) {
    router.navigateByUrl("/welcome");
    return false;
  }

  return true;
};
