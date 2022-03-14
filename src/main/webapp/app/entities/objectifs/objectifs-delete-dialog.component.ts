import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IObjectifs } from 'app/shared/model/objectifs.model';
import { ObjectifsService } from './objectifs.service';

@Component({
  templateUrl: './objectifs-delete-dialog.component.html'
})
export class ObjectifsDeleteDialogComponent {
  objectifs?: IObjectifs;

  constructor(protected objectifsService: ObjectifsService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.objectifsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('objectifsListModification');
      this.activeModal.close();
    });
  }
}
