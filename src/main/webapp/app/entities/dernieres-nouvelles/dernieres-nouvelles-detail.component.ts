import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';

@Component({
  selector: 'jhi-dernieres-nouvelles-detail',
  templateUrl: './dernieres-nouvelles-detail.component.html'
})
export class DernieresNouvellesDetailComponent implements OnInit {
  dernieresNouvelles: IDernieresNouvelles | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dernieresNouvelles }) => (this.dernieresNouvelles = dernieresNouvelles));
  }

  previousState(): void {
    window.history.back();
  }
}
