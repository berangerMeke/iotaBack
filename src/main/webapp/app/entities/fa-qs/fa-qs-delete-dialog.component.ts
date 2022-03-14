import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IFAQs } from 'app/shared/model/fa-qs.model';
import { FAQsService } from './fa-qs.service';

@Component({
  templateUrl: './fa-qs-delete-dialog.component.html'
})
export class FAQsDeleteDialogComponent {
  fAQs?: IFAQs;

  constructor(protected fAQsService: FAQsService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.fAQsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('fAQsListModification');
      this.activeModal.close();
    });
  }
}
