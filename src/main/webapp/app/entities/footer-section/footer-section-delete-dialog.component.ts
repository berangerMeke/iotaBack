import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IFooterSection } from 'app/shared/model/footer-section.model';
import { FooterSectionService } from './footer-section.service';

@Component({
  templateUrl: './footer-section-delete-dialog.component.html'
})
export class FooterSectionDeleteDialogComponent {
  footerSection?: IFooterSection;

  constructor(
    protected footerSectionService: FooterSectionService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.footerSectionService.delete(id).subscribe(() => {
      this.eventManager.broadcast('footerSectionListModification');
      this.activeModal.close();
    });
  }
}
