import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IAvantages } from 'app/shared/model/avantages.model';

@Component({
  selector: 'jhi-avantages-detail',
  templateUrl: './avantages-detail.component.html'
})
export class AvantagesDetailComponent implements OnInit {
  avantages: IAvantages | null = null;

  constructor(protected dataUtils: JhiDataUtils, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ avantages }) => (this.avantages = avantages));
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
