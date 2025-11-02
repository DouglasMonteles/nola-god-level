import { Routes } from '@angular/router';
import { Welcome } from './pages/welcome/welcome';
import { Dashboard } from './pages/dashboard/dashboard';
import { authGuard } from './guards/auth-guard';
import { redirectToLoginGuard } from './guards/redirect-to-login-guard';

export const routes: Routes = [
  {
    path: "",
    redirectTo: "welcome",
    pathMatch: "full",
  },
  {
    path: "welcome",
    component: Welcome,
    pathMatch: "full",
    title: "Welcome",
    canActivate: [
      authGuard
    ]
  },
  {
    path: "dashboard",
    component: Dashboard,
    pathMatch: "full",
    title: "Dashboard",
    canActivate: [
      redirectToLoginGuard
    ],
  },

];
