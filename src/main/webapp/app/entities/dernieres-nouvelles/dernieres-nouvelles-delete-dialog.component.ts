import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IDernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';
import { DernieresNouvellesService } from './dernieres-nouvelles.service';

@Component({
  templateUrl: './dernieres-nouvelles-delete-dialog.component.html'
})
export class DernieresNouvellesDeleteDialogComponent {
  dernieresNouvelles?: IDernieresNouvelles;

  constructor(
    protected dernieresNouvellesService: DernieresNouvellesService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.dernieresNouvellesService.delete(id).subscribe(() => {
      this.eventManager.broadcast('dernieresNouvellesListModification');
      this.activeModal.close();
    });
  }
}
