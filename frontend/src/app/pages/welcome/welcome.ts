import { Component, ChangeDetectionStrategy } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-welcome',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
  ],
  templateUrl: './welcome.html',
  styleUrl: './welcome.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class Welcome {

  form: FormGroup;

  constructor(private _formBuilder: FormBuilder) {
    this.form = this._formBuilder.group({
      username: ['', [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(12),
      ]]
    });
  }

  hasError(field: string): boolean {
    return this.form.controls[field].errors != null;
  }

  getFieldError(field: string): string | null {
    const control = this.form.controls[field]

    if (control.hasError('required')) {
      return "Esse campo é obrigatório";
    }

    if (control.hasError('minlength')) {
      return "A quantidade mínima de caracteres é 3";
    }

    if (control.hasError('maxlength')) {
      return "A quantidade máxima de caracteres é 12";
    }

    return null;
  }

  isFormInvalid(): boolean {
    return this.form.invalid;
  }

  handleLoginSubmit(): void {
    console.log(this.form.controls['username'].errors)
  }

}
