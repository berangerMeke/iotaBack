import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAccueil } from 'app/shared/model/accueil.model';
import { AccueilService } from './accueil.service';

@Component({
  templateUrl: './accueil-delete-dialog.component.html'
})
export class AccueilDeleteDialogComponent {
  accueil?: IAccueil;

  constructor(protected accueilService: AccueilService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.accueilService.delete(id).subscribe(() => {
      this.eventManager.broadcast('accueilListModification');
      this.activeModal.close();
    });
  }
}
