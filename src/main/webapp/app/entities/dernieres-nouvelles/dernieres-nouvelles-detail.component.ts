import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IDernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';

@Component({
  selector: 'jhi-dernieres-nouvelles-detail',
  templateUrl: './dernieres-nouvelles-detail.component.html'
})
export class DernieresNouvellesDetailComponent implements OnInit {
  dernieresNouvelles: IDernieresNouvelles | null = null;

  constructor(protected dataUtils: JhiDataUtils, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dernieresNouvelles }) => (this.dernieresNouvelles = dernieresNouvelles));
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
