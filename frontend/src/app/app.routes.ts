import { Routes } from '@angular/router';
import { Welcome } from './pages/welcome/welcome';
import { Dashboard } from './pages/dashboard/dashboard';
import { authGuard } from './guards/auth-guard';
import { redirectToLoginGuard } from './guards/redirect-to-login-guard';
import { ProductSaleByPeriod } from './pages/dashboard/product-sale-by-period/product-sale-by-period';
import { DefaultReports } from './pages/dashboard/default-reports/default-reports';

export const routes: Routes = [
  {
    path: "",
    redirectTo: "welcome",
    pathMatch: "full",
  },
  {
    path: "welcome",
    component: Welcome,
    title: "Welcome",
    canActivate: [
      authGuard
    ]
  },
  {
    path: "dashboard",
    component: Dashboard,
    canActivate: [
      redirectToLoginGuard
    ],
    children: [
      {
        path: "",
        component: DefaultReports,
        title: "Dashboard",
        pathMatch: "full",
      },
      {
        path: "product-sale-by-period",
        component: ProductSaleByPeriod,
        title: "Produtos vendidos por período",
      }
    ]
  }

];
