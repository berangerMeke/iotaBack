import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IPrivacyPolicy } from 'app/shared/model/privacy-policy.model';

@Component({
  selector: 'jhi-privacy-policy-detail',
  templateUrl: './privacy-policy-detail.component.html'
})
export class PrivacyPolicyDetailComponent implements OnInit {
  privacyPolicy: IPrivacyPolicy | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ privacyPolicy }) => (this.privacyPolicy = privacyPolicy));
  }

  previousState(): void {
    window.history.back();
  }
}
