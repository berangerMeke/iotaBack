import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IAPropos } from 'app/shared/model/a-propos.model';

@Component({
  selector: 'jhi-a-propos-detail',
  templateUrl: './a-propos-detail.component.html'
})
export class AProposDetailComponent implements OnInit {
  aPropos: IAPropos | null = null;

  constructor(protected dataUtils: JhiDataUtils, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ aPropos }) => (this.aPropos = aPropos));
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
