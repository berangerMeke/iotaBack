import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IAccueil } from 'app/shared/model/accueil.model';

@Component({
  selector: 'jhi-accueil-detail',
  templateUrl: './accueil-detail.component.html'
})
export class AccueilDetailComponent implements OnInit {
  accueil: IAccueil | null = null;

  constructor(protected dataUtils: JhiDataUtils, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ accueil }) => (this.accueil = accueil));
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
