import { Component, AfterViewInit, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';

// import { LoginService } from 'app/core/login/login.service';

@Component({
  selector: 'jhi-login-modal',
  templateUrl: './login.component.html'
})
export class LoginModalComponent implements AfterViewInit {
  @ViewChild('username', { static: false })
  username?: ElementRef;

  authenticationError = false;

  loginForm = this.fb.group({
    username: [''],
    password: [''],
    rememberMe: [false]
  });

  constructor(private router: Router, public activeModal: NgbActiveModal, private fb: FormBuilder) {}

  ngAfterViewInit(): void {
    if (this.username) {
      this.username.nativeElement.focus();
    }
  }

  cancel(): void {
    this.authenticationError = false;
    this.loginForm.patchValue({
      username: '',
      password: ''
    });
    this.activeModal.dismiss('cancel');
  }


  register(): void {
    this.activeModal.dismiss('to state register');
    this.router.navigate(['/account/register']);
  }

  requestResetPassword(): void {
    this.activeModal.dismiss('to state requestReset');
    this.router.navigate(['/account/reset', 'request']);
  }
}
