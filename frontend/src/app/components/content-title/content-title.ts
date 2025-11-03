import { Component, input } from '@angular/core';

@Component({
  selector: 'app-content-title',
  imports: [],
  templateUrl: './content-title.html',
  styleUrl: './content-title.scss',
})
export class ContentTitle {

  title = input("");

}
