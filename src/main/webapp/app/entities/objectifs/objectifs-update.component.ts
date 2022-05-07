import { Component, OnInit, ElementRef } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Location } from '@angular/common';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';
import {TransfertDataService} from '../../core/services/transfert-data.service'
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';

import { IObjectifs, Objectifs } from 'app/shared/model/objectifs.model';
import { ObjectifsService } from './objectifs.service';
import { AlertError } from 'app/shared/alert/alert-error.model';

@Component({
  selector: 'jhi-objectifs-update',
  templateUrl: './objectifs-update.component.html',
  styleUrls: ['./objectifs-update.scss']
})
export class ObjectifsUpdateComponent implements OnInit {
  isSaving = false;
  eltChoisi: any;

  public Editor = ClassicEditor
  isObjectifsNoExist: any;

  editForm = this.fb.group({
    id: [],
    titreFr: ['', Validators.required],
    titreEn: ['', Validators.required],
    titreGer: ['', Validators.required],
    titreSw: ['', Validators.required],
    sousTitreFr: ['', Validators.required],
    sousTitreEn: ['', Validators.required],
    sousTitreGer: ['', Validators.required],
    sousTitreSw: ['', Validators.required],
    textParagraphe1Fr: ['', Validators.required],
    textParagraphe1En: ['', Validators.required],
    textParagraphe1Ger: ['', Validators.required],
    textParagraphe1Sw: ['', Validators.required],
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
    image: ['', Validators.required],
    imageContentType: ['', Validators.required]
  });

  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected objectifsService: ObjectifsService,
    protected elementRef: ElementRef,
    private location: Location,
    public transfertDataService: TransfertDataService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {
      ClassicEditor.defaultConfig = {
        toolbar: {
            items: [
                'heading',
                '|',
                'bold',
                'italic',
                'link',
                'bulletedList',
                'numberedList',
              //  'uploadImage',
              // 'blockQuote',
                'undo',
                'redo'
            ]
        },
        image: {
            toolbar: [
                'imageStyle:inline',
                'imageStyle:block',
                'imageStyle:side',
                '|',
                'toggleImageCaption',
                'imageTextAlternative'
            ]
        },
        language: 'en'
      };
  }

  ngOnInit(): void {
    this.isObjectifsNoExist = localStorage.getItem('isNewObjectifs'); 
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ objectifs }) => {
      this.updateForm(objectifs);
    });
  }

  updateForm(objectifs: IObjectifs): void {
    this.editForm.patchValue({
      id: objectifs.id,
      titreFr: objectifs.titreFr,
      titreEn: objectifs.titreEn,
      titreGer: objectifs.titreGer,
      titreSw: objectifs.titreSw,
      sousTitreFr: objectifs.sousTitreFr,
      sousTitreEn: objectifs.sousTitreEn,
      sousTitreGer: objectifs.sousTitreGer,
      sousTitreSw: objectifs.sousTitreSw,
      textParagraphe1Fr: objectifs.textParagraphe1Fr,
      textParagraphe1En: objectifs.textParagraphe1En,
      textParagraphe1Ger: objectifs.textParagraphe1Ger,
      textParagraphe1Sw: objectifs.textParagraphe1Sw,
      textParagraphe2Fr: objectifs.textParagraphe2Fr,
      textParagraphe2En: objectifs.textParagraphe2En,
      textParagraphe2Ger: objectifs.textParagraphe2Ger,
      textParagraphe2Sw: objectifs.textParagraphe2Sw,
      textParagraphe3Fr: objectifs.textParagraphe3Fr,
      textParagraphe3En: objectifs.textParagraphe3En,
      textParagraphe3Ger: objectifs.textParagraphe3Ger,
      textParagraphe3Sw: objectifs.textParagraphe3Sw,
      textParagraphe4Fr: objectifs.textParagraphe4Fr,
      textParagraphe4En: objectifs.textParagraphe4En,
      textParagraphe4Ger: objectifs.textParagraphe4Ger,
      textParagraphe4Sw: objectifs.textParagraphe4Sw,
      textParagraphe5Fr: objectifs.textParagraphe5Fr,
      textParagraphe5En: objectifs.textParagraphe5En,
      textParagraphe5Ger: objectifs.textParagraphe5Ger,
      textParagraphe5Sw: objectifs.textParagraphe5Sw,
      image: objectifs.image,
      imageContentType: objectifs.imageContentType
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
    localStorage.removeItem("isNewObjectifs");
    window.history.back();
  }

  back(): void {
    this.location.back()
    localStorage.removeItem("isNewObjectifs");
  } 

  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  save(): void {
    this.isSaving = true;
    const objectifs = this.createFromForm();
    if (objectifs.id !== undefined) {
      localStorage.removeItem("isNewObjectifs");
      this.subscribeToSaveResponse(this.objectifsService.update(objectifs));
    } else {
      localStorage.removeItem("isNewObjectifs");
      this.subscribeToSaveResponse(this.objectifsService.create(objectifs));
    }
  }

  private createFromForm(): IObjectifs {
    return {
      ...new Objectifs(),
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

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IObjectifs>>): void {
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
