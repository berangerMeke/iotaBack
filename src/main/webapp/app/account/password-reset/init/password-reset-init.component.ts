import { Component, AfterViewInit, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Location } from '@angular/common';

import { PasswordResetInitService } from './password-reset-init.service';

@Component({
  selector: 'jhi-password-reset-init',
  templateUrl: './password-reset-init.component.html',
  styleUrls: ['./init.scss']
})
export class PasswordResetInitComponent implements AfterViewInit {
  @ViewChild('email', { static: false })
  email?: ElementRef;

  success = false;
  resetRequestForm = this.fb.group({
    email: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(254), Validators.email]]
  });

  constructor(private passwordResetInitService: PasswordResetInitService,
              private location: Location,  
              private fb: FormBuilder) {}

  ngAfterViewInit(): void {
    if (this.email) {
      this.email.nativeElement.focus();
    }
  }

  back(): void {
    this.location.back()
  }

  requestReset(): void {
    this.passwordResetInitService.save(this.resetRequestForm.get(['email'])!.value).subscribe(() => (this.success = true));
  }
}
