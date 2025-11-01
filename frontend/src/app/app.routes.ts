import { Routes } from '@angular/router';
import { Welcome } from './pages/welcome/welcome';
import { Dashboard } from './pages/dashboard/dashboard';
import { authGuard } from './guards/auth-guard';

export const routes: Routes = [
  {
    path: "",
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
    title: "Dashboard"
  }
];
