import { Component, OnInit, ElementRef } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';
import {TransfertDataService} from '../../core/services/transfert-data.service'

import { IAccueil, Accueil } from 'app/shared/model/accueil.model';
import { AccueilService } from './accueil.service';
import { AlertError } from 'app/shared/alert/alert-error.model';


@Component({
  selector: 'jhi-accueil-update',
  templateUrl: './accueil-update.component.html'
})
export class AccueilUpdateComponent implements OnInit {
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
    image: [],
    imageContentType: []
  });


  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected accueilService: AccueilService,
    protected elementRef: ElementRef,
    public transfertDataService: TransfertDataService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ accueil }) => {
      this.updateForm(accueil);
    });
    
  }

  updateForm(accueil: IAccueil): void {
    this.editForm.patchValue({
      id: accueil.id,
      titreFr: accueil.titreFr,
      titreEn: accueil.titreEn,
      titreGer: accueil.titreGer,
      titreSw: accueil.titreSw,
      sousTitreFr: accueil.sousTitreFr,
      sousTitreEn: accueil.sousTitreEn,
      sousTitreGer: accueil.sousTitreGer,
      sousTitreSw: accueil.sousTitreSw,
      image: accueil.image,
      imageContentType: accueil.imageContentType
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
    const accueil = this.createFromForm();
    if (accueil.id !== undefined) {
      this.subscribeToSaveResponse(this.accueilService.update(accueil));
    } else {
      this.subscribeToSaveResponse(this.accueilService.create(accueil));
    }
  }

  private createFromForm(): IAccueil {
    return {
      ...new Accueil(),
      id: this.editForm.get(['id'])!.value,
      titreFr: this.editForm.get(['titreFr'])!.value,
      titreEn: this.editForm.get(['titreEn'])!.value,
      titreGer: this.editForm.get(['titreGer'])!.value,
      titreSw: this.editForm.get(['titreSw'])!.value,
      sousTitreFr: this.editForm.get(['sousTitreFr'])!.value,
      sousTitreEn: this.editForm.get(['sousTitreEn'])!.value,
      sousTitreGer: this.editForm.get(['sousTitreGer'])!.value,
      sousTitreSw: this.editForm.get(['sousTitreSw'])!.value,
      imageContentType: this.editForm.get(['imageContentType'])!.value,
      image: this.editForm.get(['image'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IAccueil>>): void {
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
