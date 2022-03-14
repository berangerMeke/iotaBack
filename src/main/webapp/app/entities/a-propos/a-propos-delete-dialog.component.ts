import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAPropos } from 'app/shared/model/a-propos.model';
import { AProposService } from './a-propos.service';

@Component({
  templateUrl: './a-propos-delete-dialog.component.html'
})
export class AProposDeleteDialogComponent {
  aPropos?: IAPropos;

  constructor(protected aProposService: AProposService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.aProposService.delete(id).subscribe(() => {
      this.eventManager.broadcast('aProposListModification');
      this.activeModal.close();
    });
  }
}
