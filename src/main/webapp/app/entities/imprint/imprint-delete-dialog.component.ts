import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IImprint } from 'app/shared/model/imprint.model';
import { ImprintService } from './imprint.service';

@Component({
  templateUrl: './imprint-delete-dialog.component.html'
})
export class ImprintDeleteDialogComponent {
  imprint?: IImprint;

  constructor(protected imprintService: ImprintService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.imprintService.delete(id).subscribe(() => {
      this.eventManager.broadcast('imprintListModification');
      this.activeModal.close();
    });
  }
}
