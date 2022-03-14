import { Component, OnInit, ElementRef } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';
import {TransfertDataService} from '../../core/services/transfert-data.service';

import { IAPropos, APropos } from 'app/shared/model/a-propos.model';
import { AProposService } from './a-propos.service';
import { AlertError } from 'app/shared/alert/alert-error.model';

@Component({
  selector: 'jhi-a-propos-update',
  templateUrl: './a-propos-update.component.html'
})
export class AProposUpdateComponent implements OnInit {
  isSaving = false;
  eltChoisi : any;

  editForm = this.fb.group({
    id: [],
    titreFr: [],
    titreEn: [],
    titreGer: [],
    titreSw: [],
    sousTitreFr: [],
    sousTitreEn: [],
    sousTitreGer: [],
    sousTitreSw: [],
    textParagraphe1Fr: [],
    textParagraphe1En: [],
    textParagraphe1Ger: [],
    textParagraphe1Sw: [],
    textParagraphe2Fr: [],
    textParagraphe2En: [],
    textParagraphe2Ger: [],
    textParagraphe2Sw: [],
    textParagraphe3Fr: [],
    textParagraphe3En: [],
    textParagraphe3Ger: [],
    textParagraphe3Sw: [],
    textParagraphe4Fr: [],
    textParagraphe4En: [],
    textParagraphe4Ger: [],
    textParagraphe4Sw: [],
    textParagraphe5Fr: [],
    textParagraphe5En: [],
    textParagraphe5Ger: [],
    textParagraphe5Sw: [],
    image: [],
    imageContentType: []
  });

  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected aProposService: AProposService,
    protected elementRef: ElementRef,
    public transfertDataService: TransfertDataService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ aPropos }) => {
      this.updateForm(aPropos);
    });
  }

  updateForm(aPropos: IAPropos): void {
    this.editForm.patchValue({
      id: aPropos.id,
      titreFr: aPropos.titreFr,
      titreEn: aPropos.titreEn,
      titreGer: aPropos.titreGer,
      titreSw: aPropos.titreSw,
      sousTitreFr: aPropos.sousTitreFr,
      sousTitreEn: aPropos.sousTitreEn,
      sousTitreGer: aPropos.sousTitreGer,
      sousTitreSw: aPropos.sousTitreSw,
      textParagraphe1Fr: aPropos.textParagraphe1Fr,
      textParagraphe1En: aPropos.textParagraphe1En,
      textParagraphe1Ger: aPropos.textParagraphe1Ger,
      textParagraphe1Sw: aPropos.textParagraphe1Sw,
      textParagraphe2Fr: aPropos.textParagraphe2Fr,
      textParagraphe2En: aPropos.textParagraphe2En,
      textParagraphe2Ger: aPropos.textParagraphe2Ger,
      textParagraphe2Sw: aPropos.textParagraphe2Sw,
      textParagraphe3Fr: aPropos.textParagraphe3Fr,
      textParagraphe3En: aPropos.textParagraphe3En,
      textParagraphe3Ger: aPropos.textParagraphe3Ger,
      textParagraphe3Sw: aPropos.textParagraphe3Sw,
      textParagraphe4Fr: aPropos.textParagraphe4Fr,
      textParagraphe4En: aPropos.textParagraphe4En,
      textParagraphe4Ger: aPropos.textParagraphe4Ger,
      textParagraphe4Sw: aPropos.textParagraphe4Sw,
      textParagraphe5Fr: aPropos.textParagraphe5Fr,
      textParagraphe5En: aPropos.textParagraphe5En,
      textParagraphe5Ger: aPropos.textParagraphe5Ger,
      textParagraphe5Sw: aPropos.textParagraphe5Sw,
      image: aPropos.image,
      imageContentType: aPropos.imageContentType
    });
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    this.dataUtils.openFile(contentType, base64String);
  }

  setFileData(event: Event, field: string, isImage: boolean): void {
    this.dataUtils.loadFileToForm(event, this.editForm, field, isImage).subscribe(null, (err: JhiFileLoadError) => {
      this.eventManager.broadcast(
        new JhiEventWithContent<AlertError>('iotaOrignAdminApp.error', { ...err, key: 'error.file.' + err.key })
      );
    });
  }

  clearInputImage(field: string, fieldContentType: string, idInput: string): void {
    this.editForm.patchValue({
      [field]: null,
      [fieldContentType]: null
    });
    if (this.elementRef && idInput && this.elementRef.nativeElement.querySelector('#' + idInput)) {
      this.elementRef.nativeElement.querySelector('#' + idInput).value = null;
    }
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const aPropos = this.createFromForm();
    if (aPropos.id !== undefined) {
      this.subscribeToSaveResponse(this.aProposService.update(aPropos));
    } else {
      this.subscribeToSaveResponse(this.aProposService.create(aPropos));
    }
  }

  private createFromForm(): IAPropos {
    return {
      ...new APropos(),
      id: this.editForm.get(['id'])!.value,
      titreFr: this.editForm.get(['titreFr'])!.value,
      titreEn: this.editForm.get(['titreEn'])!.value,
      titreGer: this.editForm.get(['titreGer'])!.value,
      titreSw: this.editForm.get(['titreSw'])!.value,
      sousTitreFr: this.editForm.get(['sousTitreFr'])!.value,
      sousTitreEn: this.editForm.get(['sousTitreEn'])!.value,
      sousTitreGer: this.editForm.get(['sousTitreGer'])!.value,
      sousTitreSw: this.editForm.get(['sousTitreSw'])!.value,
      textParagraphe1Fr: this.editForm.get(['textParagraphe1Fr'])!.value,
      textParagraphe1En: this.editForm.get(['textParagraphe1En'])!.value,
      textParagraphe1Ger: this.editForm.get(['textParagraphe1Ger'])!.value,
      textParagraphe1Sw: this.editForm.get(['textParagraphe1Sw'])!.value,
      textParagraphe2Fr: this.editForm.get(['textParagraphe2Fr'])!.value,
      textParagraphe2En: this.editForm.get(['textParagraphe2En'])!.value,
      textParagraphe2Ger: this.editForm.get(['textParagraphe2Ger'])!.value,
      textParagraphe2Sw: this.editForm.get(['textParagraphe2Sw'])!.value,
      textParagraphe3Fr: this.editForm.get(['textParagraphe3Fr'])!.value,
      textParagraphe3En: this.editForm.get(['textParagraphe3En'])!.value,
      textParagraphe3Ger: this.editForm.get(['textParagraphe3Ger'])!.value,
      textParagraphe3Sw: this.editForm.get(['textParagraphe3Sw'])!.value,
      textParagraphe4Fr: this.editForm.get(['textParagraphe4Fr'])!.value,
      textParagraphe4En: this.editForm.get(['textParagraphe4En'])!.value,
      textParagraphe4Ger: this.editForm.get(['textParagraphe4Ger'])!.value,
      textParagraphe4Sw: this.editForm.get(['textParagraphe4Sw'])!.value,
      textParagraphe5Fr: this.editForm.get(['textParagraphe5Fr'])!.value,
      textParagraphe5En: this.editForm.get(['textParagraphe5En'])!.value,
      textParagraphe5Ger: this.editForm.get(['textParagraphe5Ger'])!.value,
      textParagraphe5Sw: this.editForm.get(['textParagraphe5Sw'])!.value,
      imageContentType: this.editForm.get(['imageContentType'])!.value,
      image: this.editForm.get(['image'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IAPropos>>): void {
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
