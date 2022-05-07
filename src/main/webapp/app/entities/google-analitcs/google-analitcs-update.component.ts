import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';

import { IGoogleAnalitcs, GoogleAnalitcs } from 'app/shared/model/google-analitcs.model';
import { GoogleAnalitcsService } from './google-analitcs.service';

@Component({
  selector: 'jhi-google-analitcs-update',
  templateUrl: './google-analitcs-update.component.html',
  styleUrls: ['./google-analytics-update.scss']
})
export class GoogleAnalitcsUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    googleAnalyticsID: [null, [Validators.required]]
  });

  isGoogleStatIdNoExist: any;

  constructor(
        protected googleAnalitcsService: GoogleAnalitcsService, 
        protected activatedRoute: ActivatedRoute, 
        private location: Location,
        private fb: FormBuilder) {}

  ngOnInit(): void {
    this.isGoogleStatIdNoExist = localStorage.getItem('isNew'); 
    this.activatedRoute.data.subscribe(({ googleAnalitcs }) => {
      this.updateForm(googleAnalitcs);
    });
  }

  back(): void {
    this.location.back()
  }

  updateForm(googleAnalitcs: IGoogleAnalitcs): void {
    this.editForm.patchValue({
      id: googleAnalitcs.id,
      googleAnalyticsID: googleAnalitcs.googleAnalyticsID
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const googleAnalitcs = this.createFromForm();
    if (googleAnalitcs.id !== undefined) {
      this.subscribeToSaveResponse(this.googleAnalitcsService.update(googleAnalitcs));
    } else {
      this.subscribeToSaveResponse(this.googleAnalitcsService.create(googleAnalitcs));
    }
  }

  private createFromForm(): IGoogleAnalitcs {
    return {
      ...new GoogleAnalitcs(),
      id: this.editForm.get(['id'])!.value,
      googleAnalyticsID: this.editForm.get(['googleAnalyticsID'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IGoogleAnalitcs>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
