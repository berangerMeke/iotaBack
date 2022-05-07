import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IGoogleAnalitcs } from 'app/shared/model/google-analitcs.model';
import { GoogleAnalitcsService } from './google-analitcs.service';

@Component({
  templateUrl: './google-analitcs-delete-dialog.component.html'
})
export class GoogleAnalitcsDeleteDialogComponent {
  googleAnalitcs?: IGoogleAnalitcs;

  constructor(
    protected googleAnalitcsService: GoogleAnalitcsService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.googleAnalitcsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('googleAnalitcsListModification');
      this.activeModal.close();
    });
  }
}
