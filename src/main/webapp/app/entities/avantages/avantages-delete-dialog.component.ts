import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAvantages } from 'app/shared/model/avantages.model';
import { AvantagesService } from './avantages.service';

@Component({
  templateUrl: './avantages-delete-dialog.component.html'
})
export class AvantagesDeleteDialogComponent {
  avantages?: IAvantages;

  constructor(protected avantagesService: AvantagesService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.avantagesService.delete(id).subscribe(() => {
      this.eventManager.broadcast('avantagesListModification');
      this.activeModal.close();
    });
  }
}
