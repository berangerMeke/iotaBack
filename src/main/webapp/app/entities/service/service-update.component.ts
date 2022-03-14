import { Component, OnInit, ElementRef } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';
import {TransfertDataService} from '../../core/services/transfert-data.service';

import { IService, Service } from 'app/shared/model/service.model';
import { ServiceService } from './service.service';
import { AlertError } from 'app/shared/alert/alert-error.model';

@Component({
  selector: 'jhi-service-update',
  templateUrl: './service-update.component.html'
})
export class ServiceUpdateComponent implements OnInit {
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
    protected serviceService: ServiceService,
    protected elementRef: ElementRef,
    public transfertDataService: TransfertDataService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ service }) => {
      this.updateForm(service);
    });
  }

  updateForm(service: IService): void {
    this.editForm.patchValue({
      id: service.id,
      titreFr: service.titreFr,
      titreEn: service.titreEn,
      titreGer: service.titreGer,
      titreSw: service.titreSw,
      sousTitreFr: service.sousTitreFr,
      sousTitreEn: service.sousTitreEn,
      sousTitreGer: service.sousTitreGer,
      sousTitreSw: service.sousTitreSw,
      textParagraphe1Fr: service.textParagraphe1Fr,
      textParagraphe1En: service.textParagraphe1En,
      textParagraphe1Ger: service.textParagraphe1Ger,
      textParagraphe1Sw: service.textParagraphe1Sw,
      textParagraphe2Fr: service.textParagraphe2Fr,
      textParagraphe2En: service.textParagraphe2En,
      textParagraphe2Ger: service.textParagraphe2Ger,
      textParagraphe2Sw: service.textParagraphe2Sw,
      textParagraphe3Fr: service.textParagraphe3Fr,
      textParagraphe3En: service.textParagraphe3En,
      textParagraphe3Ger: service.textParagraphe3Ger,
      textParagraphe3Sw: service.textParagraphe3Sw,
      textParagraphe4Fr: service.textParagraphe4Fr,
      textParagraphe4En: service.textParagraphe4En,
      textParagraphe4Ger: service.textParagraphe4Ger,
      textParagraphe4Sw: service.textParagraphe4Sw,
      textParagraphe5Fr: service.textParagraphe5Fr,
      textParagraphe5En: service.textParagraphe5En,
      textParagraphe5Ger: service.textParagraphe5Ger,
      textParagraphe5Sw: service.textParagraphe5Sw,
      image: service.image,
      imageContentType: service.imageContentType
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
    const service = this.createFromForm();
    if (service.id !== undefined) {
      this.subscribeToSaveResponse(this.serviceService.update(service));
    } else {
      this.subscribeToSaveResponse(this.serviceService.create(service));
    }
  }

  private createFromForm(): IService {
    return {
      ...new Service(),
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

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IService>>): void {
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
