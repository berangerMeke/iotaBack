import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IImprint } from 'app/shared/model/imprint.model';

@Component({
  selector: 'jhi-imprint-detail',
  templateUrl: './imprint-detail.component.html'
})
export class ImprintDetailComponent implements OnInit {
  imprint: IImprint | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ imprint }) => (this.imprint = imprint));
  }

  previousState(): void {
    window.history.back();
  }
}
