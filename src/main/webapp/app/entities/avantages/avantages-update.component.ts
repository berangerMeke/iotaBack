import { Component, OnInit, ElementRef } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Location } from '@angular/common';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';
import {TransfertDataService} from '../../core/services/transfert-data.service'

import { IAvantages, Avantages } from 'app/shared/model/avantages.model';
import { AvantagesService } from './avantages.service';
import { AlertError } from 'app/shared/alert/alert-error.model';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';


@Component({
  selector: 'jhi-avantages-update',
  templateUrl: './avantages-update.component.html',
  styleUrls: ['./avantages-update.scss']
})
export class AvantagesUpdateComponent implements OnInit {
  isSaving = false;
  eltChoisi : any;

  public Editor = ClassicEditor;

  isAvantagesNoExist: any;

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
    textParagraphe1FR: ['', Validators.required],
    textParagraphe1En: ['', Validators.required],
    textParagraphe1Ger: ['', Validators.required],
    textParagraphe1Sw: ['', Validators.required],
    textParagraphe2Fr: [],
    textParagraphe2En: [],
    textParagraphe2Ger: [],
    textParagraphe2Sw: [],
    textParagraphe3FR: [],
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
    textParagraphe6Fr: [],
    textParagraphe6En: [],
    textParagraphe6Ger: [],
    textParagraphe6Sw: [],
    textParagraphe7Fr: [],
    textParagraphe7En: [],
    textParagraphe7Ger: [],
    textParagraphe7Sw: [],
    textParagraphe8Fr: [],
    textParagraphe8En: [],
    textParagraphe8Ger: [],
    textParagraphe8Sw: [],
    image: ['', Validators.required],
    imageContentType: ['', Validators.required]
  });

  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected avantagesService: AvantagesService,
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
    this.isAvantagesNoExist = localStorage.getItem('isNewAvantages'); 
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ avantages }) => {
      this.updateForm(avantages);
    });
  }

  updateForm(avantages: IAvantages): void {
    this.editForm.patchValue({
      id: avantages.id,
      titreFr: avantages.titreFr,
      titreEn: avantages.titreEn,
      titreGer: avantages.titreGer,
      titreSw: avantages.titreSw,
      sousTitreFr: avantages.sousTitreFr,
      sousTitreEn: avantages.sousTitreEn,
      sousTitreGer: avantages.sousTitreGer,
      sousTitreSw: avantages.sousTitreSw,
      textParagraphe1FR: avantages.textParagraphe1FR,
      textParagraphe1En: avantages.textParagraphe1En,
      textParagraphe1Ger: avantages.textParagraphe1Ger,
      textParagraphe1Sw: avantages.textParagraphe1Sw,
      textParagraphe2Fr: avantages.textParagraphe2Fr,
      textParagraphe2En: avantages.textParagraphe2En,
      textParagraphe2Ger: avantages.textParagraphe2Ger,
      textParagraphe2Sw: avantages.textParagraphe2Sw,
      textParagraphe3FR: avantages.textParagraphe3FR,
      textParagraphe3En: avantages.textParagraphe3En,
      textParagraphe3Ger: avantages.textParagraphe3Ger,
      textParagraphe3Sw: avantages.textParagraphe3Sw,
      textParagraphe4Fr: avantages.textParagraphe4Fr,
      textParagraphe4En: avantages.textParagraphe4En,
      textParagraphe4Ger: avantages.textParagraphe4Ger,
      textParagraphe4Sw: avantages.textParagraphe4Sw,
      textParagraphe5Fr: avantages.textParagraphe5Fr,
      textParagraphe5En: avantages.textParagraphe5En,
      textParagraphe5Ger: avantages.textParagraphe5Ger,
      textParagraphe5Sw: avantages.textParagraphe5Sw,
      textParagraphe6Fr: avantages.textParagraphe6Fr,
      textParagraphe6En: avantages.textParagraphe6En,
      textParagraphe6Ger: avantages.textParagraphe6Ger,
      textParagraphe6Sw: avantages.textParagraphe6Sw,
      textParagraphe7Fr: avantages.textParagraphe7Fr,
      textParagraphe7En: avantages.textParagraphe7En,
      textParagraphe7Ger: avantages.textParagraphe7Ger,
      textParagraphe7Sw: avantages.textParagraphe7Sw,
      textParagraphe8Fr: avantages.textParagraphe8Fr,
      textParagraphe8En: avantages.textParagraphe8En,
      textParagraphe8Ger: avantages.textParagraphe8Ger,
      textParagraphe8Sw: avantages.textParagraphe8Sw,
      image: avantages.image,
      imageContentType: avantages.imageContentType
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
    localStorage.removeItem("isNewAvantages");
    window.history.back();
  }

  back(): void {
    this.location.back()
    localStorage.removeItem("isNewAvantages");
  }


  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  save(): void {
    this.isSaving = true;
    const avantages = this.createFromForm();
    if (avantages.id !== undefined) {
      localStorage.removeItem("isNewAvantages");
      this.subscribeToSaveResponse(this.avantagesService.update(avantages));
    } else {
      localStorage.removeItem("isNewAvantages");
      this.subscribeToSaveResponse(this.avantagesService.create(avantages));
    }
  }

  private createFromForm(): IAvantages {
    return {
      ...new Avantages(),
      id: this.editForm.get(['id'])!.value,
      titreFr: this.editForm.get(['titreFr'])!.value,
      titreEn: this.editForm.get(['titreEn'])!.value,
      titreGer: this.editForm.get(['titreGer'])!.value,
      titreSw: this.editForm.get(['titreSw'])!.value,
      sousTitreFr: this.editForm.get(['sousTitreFr'])!.value,
      sousTitreEn: this.editForm.get(['sousTitreEn'])!.value,
      sousTitreGer: this.editForm.get(['sousTitreGer'])!.value,
      sousTitreSw: this.editForm.get(['sousTitreSw'])!.value,
      textParagraphe1FR: this.editForm.get(['textParagraphe1FR'])!.value,
      textParagraphe1En: this.editForm.get(['textParagraphe1En'])!.value,
      textParagraphe1Ger: this.editForm.get(['textParagraphe1Ger'])!.value,
      textParagraphe1Sw: this.editForm.get(['textParagraphe1Sw'])!.value,
      textParagraphe2Fr: this.editForm.get(['textParagraphe2Fr'])!.value,
      textParagraphe2En: this.editForm.get(['textParagraphe2En'])!.value,
      textParagraphe2Ger: this.editForm.get(['textParagraphe2Ger'])!.value,
      textParagraphe2Sw: this.editForm.get(['textParagraphe2Sw'])!.value,
      textParagraphe3FR: this.editForm.get(['textParagraphe3FR'])!.value,
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
      textParagraphe6Fr: this.editForm.get(['textParagraphe6Fr'])!.value,
      textParagraphe6En: this.editForm.get(['textParagraphe6En'])!.value,
      textParagraphe6Ger: this.editForm.get(['textParagraphe6Ger'])!.value,
      textParagraphe6Sw: this.editForm.get(['textParagraphe6Sw'])!.value,
      textParagraphe7Fr: this.editForm.get(['textParagraphe7Fr'])!.value,
      textParagraphe7En: this.editForm.get(['textParagraphe7En'])!.value,
      textParagraphe7Ger: this.editForm.get(['textParagraphe7Ger'])!.value,
      textParagraphe7Sw: this.editForm.get(['textParagraphe7Sw'])!.value,
      textParagraphe8Fr: this.editForm.get(['textParagraphe8Fr'])!.value,
      textParagraphe8En: this.editForm.get(['textParagraphe8En'])!.value,
      textParagraphe8Ger: this.editForm.get(['textParagraphe8Ger'])!.value,
      textParagraphe8Sw: this.editForm.get(['textParagraphe8Sw'])!.value,
      imageContentType: this.editForm.get(['imageContentType'])!.value,
      image: this.editForm.get(['image'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IAvantages>>): void {
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
