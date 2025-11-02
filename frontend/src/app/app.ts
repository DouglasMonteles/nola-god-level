import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Welcome } from "./pages/welcome/welcome";
import { NavContainerComponent } from "./components/nav-container/nav-container.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Welcome, NavContainerComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('frontend');
}
