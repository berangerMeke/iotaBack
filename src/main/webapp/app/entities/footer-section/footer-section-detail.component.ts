import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IFooterSection } from 'app/shared/model/footer-section.model';

@Component({
  selector: 'jhi-footer-section-detail',
  templateUrl: './footer-section-detail.component.html'
})
export class FooterSectionDetailComponent implements OnInit {
  footerSection: IFooterSection | null = null;

  constructor(protected dataUtils: JhiDataUtils, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ footerSection }) => (this.footerSection = footerSection));
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    this.dataUtils.openFile(contentType, base64String);
  }

  previousState(): void {
    window.history.back();
  }
}
