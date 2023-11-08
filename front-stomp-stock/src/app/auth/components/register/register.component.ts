import { Component } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { TokenResponse } from 'src/app/core/models/auth/tokenResponse.interface';
import { AuthService } from 'src/app/core/services/auth.service';
import { ErrorHandlerService } from 'src/app/core/services/error-handler.service';
import { LocalStorageService } from 'src/app/core/services/local-storage.service';
import { Location } from '@angular/common';
import { RegisterRequest } from 'src/app/core/models/auth/registerRequest.interface';
import { take } from 'rxjs/operators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  public hide = true;
  public onError = false;
  public usernamePattern = /^[\w]{1,254}$/;
  public passwordPattern =
    /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\!\@\#\&\(\)\-\[\{\}\]\:\;\'\,\?\/\*\~\$\^\+\=\<\>]).{8,254}$/;
  public form = this.fb.group({
    accountname: [
      '',
      [Validators.required, Validators.pattern(this.usernamePattern)],
    ],
    email: ['', [Validators.required, Validators.email]],
    accountpassword: [
      '',
      // [Validators.required, Validators.pattern(this.passwordPattern)],
    ],
  });

  constructor(
    private authService: AuthService,
    private errorHandler: ErrorHandlerService,
    private fb: FormBuilder,
    private router: Router,
    private localStorageService: LocalStorageService,
    private location: Location
  ) {}

  public submit(): void {
    const registerRequest = this.form.value as RegisterRequest;
    this.authService.register(registerRequest).pipe(take(1)).subscribe({
      next: (response: TokenResponse) => {
        this.localStorageService.setToken(response.token);
        this.router.navigate(['/tchats']);
      },
      error: (error) => this.errorHandler.handleError(error),
    });
  }

  /**
   * Return to previous page
   */
  goBack() {
    this.location.back();
  }
}
