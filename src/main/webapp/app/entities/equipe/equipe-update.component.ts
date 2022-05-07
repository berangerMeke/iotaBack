import { Component, OnInit, ElementRef } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';
import {TransfertDataService} from '../../core/services/transfert-data.service';


import { IEquipe, Equipe } from 'app/shared/model/equipe.model';
import { EquipeService } from './equipe.service';
import { AlertError } from 'app/shared/alert/alert-error.model';

@Component({
  selector: 'jhi-equipe-update',
  templateUrl: './equipe-update.component.html'
})
export class EquipeUpdateComponent implements OnInit {
  isSaving = false;
  eltChoisi : any;

  editForm = this.fb.group({
    id: [],
    titreFr: [],
    titreEn: [],
    titreGer: [],
    titreSw: [],
    souTitreFr: [],
    souTitreEn: [],
    souTitreGer: [],
    souTitreSw: [],
    nom1: [],
    nom2: [],
    nom3: [],
    nom4: [],
    nom5: [],
    nom6: [],
    nom7: [],
    nom8: [],
    prenom1: [],
    prenom2: [],
    prenom3: [],
    prenom4: [],
    prenom5: [],
    prenom6: [],
    prenom7: [],
    prenom8: [],
    qualite1: [],
    qualite2: [],
    qualite3: [],
    qualite4: [],
    qualite5: [],
    qualite6: [],
    qualite7: [],
    qualite8: [],
    image1: [],
    image1ContentType: [],
    image2: [],
    image2ContentType: [],
    image3: [],
    image3ContentType: [],
    image4: [],
    image4ContentType: [],
    image5: [],
    image5ContentType: [],
    image6: [],
    image6ContentType: [],
    image7: [],
    image7ContentType: [],
    image8: [],
    image8ContentType: []
  });

  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected equipeService: EquipeService,
    public transfertDataService: TransfertDataService,
    protected elementRef: ElementRef,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ equipe }) => {
      this.updateForm(equipe);
    });
  }

  updateForm(equipe: IEquipe): void {
    this.editForm.patchValue({
      id: equipe.id,
      titreFr: equipe.titreFr,
      titreEn: equipe.titreEn,
      titreGer: equipe.titreGer,
      titreSw: equipe.titreSw,
      souTitreFr: equipe.souTitreFr,
      souTitreEn: equipe.souTitreEn,
      souTitreGer: equipe.souTitreGer,
      souTitreSw: equipe.souTitreSw,
      nom1: equipe.nom1,
      nom2: equipe.nom2,
      nom3: equipe.nom3,
      nom4: equipe.nom4,
      nom5: equipe.nom5,
      nom6: equipe.nom6,
      nom7: equipe.nom7,
      nom8: equipe.nom8,
      prenom1: equipe.prenom1,
      prenom2: equipe.prenom2,
      prenom3: equipe.prenom3,
      prenom4: equipe.prenom4,
      prenom5: equipe.prenom5,
      prenom6: equipe.prenom6,
      prenom7: equipe.prenom7,
      prenom8: equipe.prenom8,
      qualite1: equipe.qualite1,
      qualite2: equipe.qualite2,
      qualite3: equipe.qualite3,
      qualite4: equipe.qualite4,
      qualite5: equipe.qualite5,
      qualite6: equipe.qualite6,
      qualite7: equipe.qualite7,
      qualite8: equipe.qualite8,
      image1: equipe.image1,
      image1ContentType: equipe.image1ContentType,
      image2: equipe.image2,
      image2ContentType: equipe.image2ContentType,
      image3: equipe.image3,
      image3ContentType: equipe.image3ContentType,
      image4: equipe.image4,
      image4ContentType: equipe.image4ContentType,
      image5: equipe.image5,
      image5ContentType: equipe.image5ContentType,
      image6: equipe.image6,
      image6ContentType: equipe.image6ContentType,
      image7: equipe.image7,
      image7ContentType: equipe.image7ContentType,
      image8: equipe.image8,
      image8ContentType: equipe.image8ContentType
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

  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  save(): void {
    this.isSaving = true;
    const equipe = this.createFromForm();
    if (equipe.id !== undefined) {
      this.subscribeToSaveResponse(this.equipeService.update(equipe));
    } else {
      this.subscribeToSaveResponse(this.equipeService.create(equipe));
    }
  }

  private createFromForm(): IEquipe {
    return {
      ...new Equipe(),
      id: this.editForm.get(['id'])!.value,
      titreFr: this.editForm.get(['titreFr'])!.value,
      titreEn: this.editForm.get(['titreEn'])!.value,
      titreGer: this.editForm.get(['titreGer'])!.value,
      titreSw: this.editForm.get(['titreSw'])!.value,
      souTitreFr: this.editForm.get(['souTitreFr'])!.value,
      souTitreEn: this.editForm.get(['souTitreEn'])!.value,
      souTitreGer: this.editForm.get(['souTitreGer'])!.value,
      souTitreSw: this.editForm.get(['souTitreSw'])!.value,
      nom1: this.editForm.get(['nom1'])!.value,
      nom2: this.editForm.get(['nom2'])!.value,
      nom3: this.editForm.get(['nom3'])!.value,
      nom4: this.editForm.get(['nom4'])!.value,
      nom5: this.editForm.get(['nom5'])!.value,
      nom6: this.editForm.get(['nom6'])!.value,
      nom7: this.editForm.get(['nom7'])!.value,
      nom8: this.editForm.get(['nom8'])!.value,
      prenom1: this.editForm.get(['prenom1'])!.value,
      prenom2: this.editForm.get(['prenom2'])!.value,
      prenom3: this.editForm.get(['prenom3'])!.value,
      prenom4: this.editForm.get(['prenom4'])!.value,
      prenom5: this.editForm.get(['prenom5'])!.value,
      prenom6: this.editForm.get(['prenom6'])!.value,
      prenom7: this.editForm.get(['prenom7'])!.value,
      prenom8: this.editForm.get(['prenom8'])!.value,
      qualite1: this.editForm.get(['qualite1'])!.value,
      qualite2: this.editForm.get(['qualite2'])!.value,
      qualite3: this.editForm.get(['qualite3'])!.value,
      qualite4: this.editForm.get(['qualite4'])!.value,
      qualite5: this.editForm.get(['qualite5'])!.value,
      qualite6: this.editForm.get(['qualite6'])!.value,
      qualite7: this.editForm.get(['qualite7'])!.value,
      qualite8: this.editForm.get(['qualite8'])!.value,
      image1ContentType: this.editForm.get(['image1ContentType'])!.value,
      image1: this.editForm.get(['image1'])!.value,
      image2ContentType: this.editForm.get(['image2ContentType'])!.value,
      image2: this.editForm.get(['image2'])!.value,
      image3ContentType: this.editForm.get(['image3ContentType'])!.value,
      image3: this.editForm.get(['image3'])!.value,
      image4ContentType: this.editForm.get(['image4ContentType'])!.value,
      image4: this.editForm.get(['image4'])!.value,
      image5ContentType: this.editForm.get(['image5ContentType'])!.value,
      image5: this.editForm.get(['image5'])!.value,
      image6ContentType: this.editForm.get(['image6ContentType'])!.value,
      image6: this.editForm.get(['image6'])!.value,
      image7ContentType: this.editForm.get(['image7ContentType'])!.value,
      image7: this.editForm.get(['image7'])!.value,
      image8ContentType: this.editForm.get(['image8ContentType'])!.value,
      image8: this.editForm.get(['image8'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IEquipe>>): void {
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
