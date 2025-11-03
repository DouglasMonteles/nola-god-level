import { Component, input } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-input-text',
  imports: [
    MatFormFieldModule,
    MatInputModule,
  ],
  templateUrl: './input-text.html',
  styleUrl: './input-text.scss',
})
export class InputText {

  label = input("");
  value = input<string | number | null>("");
  isReadonly = input(false);

}
