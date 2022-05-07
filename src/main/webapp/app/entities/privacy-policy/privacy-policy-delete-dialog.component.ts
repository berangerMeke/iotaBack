import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IPrivacyPolicy } from 'app/shared/model/privacy-policy.model';
import { PrivacyPolicyService } from './privacy-policy.service';

@Component({
  templateUrl: './privacy-policy-delete-dialog.component.html'
})
export class PrivacyPolicyDeleteDialogComponent {
  privacyPolicy?: IPrivacyPolicy;

  constructor(
    protected privacyPolicyService: PrivacyPolicyService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.privacyPolicyService.delete(id).subscribe(() => {
      this.eventManager.broadcast('privacyPolicyListModification');
      this.activeModal.close();
    });
  }
}
