import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IGoogleAnalitcs } from 'app/shared/model/google-analitcs.model';

@Component({
  selector: 'jhi-google-analitcs-detail',
  templateUrl: './google-analitcs-detail.component.html'
})
export class GoogleAnalitcsDetailComponent implements OnInit {
  googleAnalitcs: IGoogleAnalitcs | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ googleAnalitcs }) => (this.googleAnalitcs = googleAnalitcs));
  }

  previousState(): void {
    window.history.back();
  }
}
