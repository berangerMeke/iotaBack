import { Component, OnInit, ElementRef } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {TransfertDataService} from '../../core/services/transfert-data.service'
import { Observable } from 'rxjs';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';

import { IDernieresNouvelles, DernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';
import { DernieresNouvellesService } from './dernieres-nouvelles.service';
import { AlertError } from 'app/shared/alert/alert-error.model';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';

@Component({
  selector: 'jhi-dernieres-nouvelles-update',
  templateUrl: './dernieres-nouvelles-update.component.html',
  styleUrls: ['./dernieres-nouvelles-update.scss']
})
export class DernieresNouvellesUpdateComponent implements OnInit {
  isSaving = false;


  isDernieresNouvellesNoExist: any;
  public Editor = ClassicEditor;

  eltChoisi: any;

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
    titreSlide1Fr: [],
    titreSlide1En: [],
    titreSlide1Ger: [],
    titreSlide1Sw: [],
    titreSlide2Fr: [],
    titreSlide2En: [],
    titreSlide2Ger: [],
    titreSlide2Sw: [],
    titreSlide3Fr: [],
    titreSlide3En: [],
    titreSlide3Ger: [],
    titreSlide3Sw: [],
    titreSlide4Fr: [],
    titreSlide4En: [],
    titreSlide4Ger: [],
    titreSlide4Sw: [],
    titreSlide5Fr: [],
    titreSlide5En: [],
    titreSlide5Ger: [],
    titreSlide5Sw: [],
    titreSlide6Fr: [],
    titreSlide6En: [],
    titreSlide6Ger: [],
    titreSlide6Sw: [],
    titreSlide7Fr: [],
    titreSlide7En: [],
    titreSlide7Ger: [],
    titreSlide7Sw: [],
    titreSlide8Fr: [],
    titreSlide8En: [],
    titreSlide8Ger: [],
    titreSlide8Sw: [],
    titreSlide9Fr: [],
    titreSlide9En: [],
    titreSlide9Ger: [],
    titreSlide9Sw: [],
    titreSlide1OFr: [],
    titreSlide1OEn: [],
    titreSlide1OGer: [],
    titreSlide1OSw: [],
    textSlide1Fr: [],
    textSlide1En: [],
    textSlide1Ger: [],
    textSlide1Sw: [],
    textSlide2Fr: [],
    textSlide2En: [],
    textSlide2Ger: [],
    textSlide2Sw: [],
    textSlide3Fr: [],
    textSlide3En: [],
    textSlide3Ger: [],
    textSlide3Sw: [],
    textSlide4Fr: [],
    textSlide4En: [],
    textSlide4Ger: [],
    textSlide4Sw: [],
    textSlide5Fr: [],
    textSlide5En: [],
    textSlide5Ger: [],
    textSlide5Sw: [],
    textSlide6Fr: [],
    textSlide6En: [],
    textSlide6Ger: [],
    textSlide6Sw: [],
    textSlide7Fr: [],
    textSlide7En: [],
    textSlide7Ger: [],
    textSlide7Sw: [],
    textSlide8Fr: [],
    textSlide8En: [],
    textSlide8Ger: [],
    textSlide8Sw: [],
    textSlide9Fr: [],
    textSlide9En: [],
    textSlide9Ger: [],
    textSlide9Sw: [],
    textSlide10Fr: [],
    textSlide10En: [],
    textSlide10Ger: [],
    textSlide10Sw: [],
    imageSlide1: [],
    imageSlide1ContentType: [],
    imageSlide2: [],
    imageSlide2ContentType: [],
    imageSlide3: [],
    imageSlide3ContentType: [],
    imageSlide4: [],
    imageSlide4ContentType: [],
    imageSlide5: [],
    imageSlide5ContentType: [],
    imageSlide6: [],
    imageSlide6ContentType: [],
    imageSlide7: [],
    imageSlide7ContentType: [],
    imageSlide8: [],
    imageSlide8ContentType: [],
    imageSlide9: [],
    imageSlide9ContentType: [],
    imageSlide10: [],
    imageSlide10ContentType: [],
    readMore1: [],
    readMore2: [],
    readMore3: [],
    readMore4: [],
    readMore5: [],
    readMore6: [],
    readMore7: [],
    readMore8: [],
    readMore9: [],
    readMore10: [],
    date1: [],
    date2: [],
    date3: [],
    date4: [],
    date5: [],
    date6: [],
    date7: [],
    date8: [],
    date9: [],
    date10: []
  });

  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    private location: Location,
    public transfertDataService: TransfertDataService, 
    protected dernieresNouvellesService: DernieresNouvellesService,
    protected elementRef: ElementRef,
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
              'fontFamily',
              'bulletedList',
              'numberedList',
            //  'uploadImage',
            // 'blockQuote',
              'undo',
              'redo'
          ]
      },
      fontFamily: {
        options: [
          'default',
          'Ubuntu, Arial, sans-serif',
          'Ubuntu Mono, Courier New, Courier, monospace'
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
    this.isDernieresNouvellesNoExist = localStorage.getItem('isNewDernieresNouvelles'); 
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ dernieresNouvelles }) => {
      this.updateForm(dernieresNouvelles);
    });
  }

  updateForm(dernieresNouvelles: IDernieresNouvelles): void {
    this.editForm.patchValue({
      id: dernieresNouvelles.id,
      titreFr: dernieresNouvelles.titreFr,
      titreEn: dernieresNouvelles.titreEn,
      titreGer: dernieresNouvelles.titreGer,
      titreSw: dernieresNouvelles.titreSw,
      sousTitreFr: dernieresNouvelles.sousTitreFr,
      sousTitreEn: dernieresNouvelles.sousTitreEn,
      sousTitreGer: dernieresNouvelles.sousTitreGer,
      sousTitreSw: dernieresNouvelles.sousTitreSw,
      titreSlide1Fr: dernieresNouvelles.titreSlide1Fr,
      titreSlide1En: dernieresNouvelles.titreSlide1En,
      titreSlide1Ger: dernieresNouvelles.titreSlide1Ger,
      titreSlide1Sw: dernieresNouvelles.titreSlide1Sw,
      titreSlide2Fr: dernieresNouvelles.titreSlide2Fr,
      titreSlide2En: dernieresNouvelles.titreSlide2En,
      titreSlide2Ger: dernieresNouvelles.titreSlide2Ger,
      titreSlide2Sw: dernieresNouvelles.titreSlide2Sw,
      titreSlide3Fr: dernieresNouvelles.titreSlide3Fr,
      titreSlide3En: dernieresNouvelles.titreSlide3En,
      titreSlide3Ger: dernieresNouvelles.titreSlide3Ger,
      titreSlide3Sw: dernieresNouvelles.titreSlide3Sw,
      titreSlide4Fr: dernieresNouvelles.titreSlide4Fr,
      titreSlide4En: dernieresNouvelles.titreSlide4En,
      titreSlide4Ger: dernieresNouvelles.titreSlide4Ger,
      titreSlide4Sw: dernieresNouvelles.titreSlide4Sw,
      titreSlide5Fr: dernieresNouvelles.titreSlide5Fr,
      titreSlide5En: dernieresNouvelles.titreSlide5En,
      titreSlide5Ger: dernieresNouvelles.titreSlide5Ger,
      titreSlide5Sw: dernieresNouvelles.titreSlide5Sw,
      titreSlide6Fr: dernieresNouvelles.titreSlide6Fr,
      titreSlide6En: dernieresNouvelles.titreSlide6En,
      titreSlide6Ger: dernieresNouvelles.titreSlide6Ger,
      titreSlide6Sw: dernieresNouvelles.titreSlide6Sw,
      titreSlide7Fr: dernieresNouvelles.titreSlide7Fr,
      titreSlide7En: dernieresNouvelles.titreSlide7En,
      titreSlide7Ger: dernieresNouvelles.titreSlide7Ger,
      titreSlide7Sw: dernieresNouvelles.titreSlide7Sw,
      titreSlide8Fr: dernieresNouvelles.titreSlide8Fr,
      titreSlide8En: dernieresNouvelles.titreSlide8En,
      titreSlide8Ger: dernieresNouvelles.titreSlide8Ger,
      titreSlide8Sw: dernieresNouvelles.titreSlide8Sw,
      titreSlide9Fr: dernieresNouvelles.titreSlide9Fr,
      titreSlide9En: dernieresNouvelles.titreSlide9En,
      titreSlide9Ger: dernieresNouvelles.titreSlide9Ger,
      titreSlide9Sw: dernieresNouvelles.titreSlide9Sw,
      titreSlide1OFr: dernieresNouvelles.titreSlide1OFr,
      titreSlide1OEn: dernieresNouvelles.titreSlide1OEn,
      titreSlide1OGer: dernieresNouvelles.titreSlide1OGer,
      titreSlide1OSw: dernieresNouvelles.titreSlide1OSw,
      textSlide1Fr: dernieresNouvelles.textSlide1Fr,
      textSlide1En: dernieresNouvelles.textSlide1En,
      textSlide1Ger: dernieresNouvelles.textSlide1Ger,
      textSlide1Sw: dernieresNouvelles.textSlide1Sw,
      textSlide2Fr: dernieresNouvelles.textSlide2Fr,
      textSlide2En: dernieresNouvelles.textSlide2En,
      textSlide2Ger: dernieresNouvelles.textSlide2Ger,
      textSlide2Sw: dernieresNouvelles.textSlide2Sw,
      textSlide3Fr: dernieresNouvelles.textSlide3Fr,
      textSlide3En: dernieresNouvelles.textSlide3En,
      textSlide3Ger: dernieresNouvelles.textSlide3Ger,
      textSlide3Sw: dernieresNouvelles.textSlide3Sw,
      textSlide4Fr: dernieresNouvelles.textSlide4Fr,
      textSlide4En: dernieresNouvelles.textSlide4En,
      textSlide4Ger: dernieresNouvelles.textSlide4Ger,
      textSlide4Sw: dernieresNouvelles.textSlide4Sw,
      textSlide5Fr: dernieresNouvelles.textSlide5Fr,
      textSlide5En: dernieresNouvelles.textSlide5En,
      textSlide5Ger: dernieresNouvelles.textSlide5Ger,
      textSlide5Sw: dernieresNouvelles.textSlide5Sw,
      textSlide6Fr: dernieresNouvelles.textSlide6Fr,
      textSlide6En: dernieresNouvelles.textSlide6En,
      textSlide6Ger: dernieresNouvelles.textSlide6Ger,
      textSlide6Sw: dernieresNouvelles.textSlide6Sw,
      textSlide7Fr: dernieresNouvelles.textSlide7Fr,
      textSlide7En: dernieresNouvelles.textSlide7En,
      textSlide7Ger: dernieresNouvelles.textSlide7Ger,
      textSlide7Sw: dernieresNouvelles.textSlide7Sw,
      textSlide8Fr: dernieresNouvelles.textSlide8Fr,
      textSlide8En: dernieresNouvelles.textSlide8En,
      textSlide8Ger: dernieresNouvelles.textSlide8Ger,
      textSlide8Sw: dernieresNouvelles.textSlide8Sw,
      textSlide9Fr: dernieresNouvelles.textSlide9Fr,
      textSlide9En: dernieresNouvelles.textSlide9En,
      textSlide9Ger: dernieresNouvelles.textSlide9Ger,
      textSlide9Sw: dernieresNouvelles.textSlide9Sw,
      textSlide10Fr: dernieresNouvelles.textSlide10Fr,
      textSlide10En: dernieresNouvelles.textSlide10En,
      textSlide10Ger: dernieresNouvelles.textSlide10Ger,
      textSlide10Sw: dernieresNouvelles.textSlide10Sw,
      imageSlide1: dernieresNouvelles.imageSlide1,
      imageSlide1ContentType: dernieresNouvelles.imageSlide1ContentType,
      imageSlide2: dernieresNouvelles.imageSlide2,
      imageSlide2ContentType: dernieresNouvelles.imageSlide2ContentType,
      imageSlide3: dernieresNouvelles.imageSlide3,
      imageSlide3ContentType: dernieresNouvelles.imageSlide3ContentType,
      imageSlide4: dernieresNouvelles.imageSlide4,
      imageSlide4ContentType: dernieresNouvelles.imageSlide4ContentType,
      imageSlide5: dernieresNouvelles.imageSlide5,
      imageSlide5ContentType: dernieresNouvelles.imageSlide5ContentType,
      imageSlide6: dernieresNouvelles.imageSlide6,
      imageSlide6ContentType: dernieresNouvelles.imageSlide6ContentType,
      imageSlide7: dernieresNouvelles.imageSlide7,
      imageSlide7ContentType: dernieresNouvelles.imageSlide7ContentType,
      imageSlide8: dernieresNouvelles.imageSlide8,
      imageSlide8ContentType: dernieresNouvelles.imageSlide8ContentType,
      imageSlide9: dernieresNouvelles.imageSlide9,
      imageSlide9ContentType: dernieresNouvelles.imageSlide9ContentType,
      imageSlide10: dernieresNouvelles.imageSlide10,
      imageSlide10ContentType: dernieresNouvelles.imageSlide10ContentType,
      readMore1: dernieresNouvelles.readMore1,
      readMore2: dernieresNouvelles.readMore2,
      readMore3: dernieresNouvelles.readMore3,
      readMore4: dernieresNouvelles.readMore4,
      readMore5: dernieresNouvelles.readMore5,
      readMore6: dernieresNouvelles.readMore6,
      readMore7: dernieresNouvelles.readMore7,
      readMore8: dernieresNouvelles.readMore8,
      readMore9: dernieresNouvelles.readMore9,
      readMore10: dernieresNouvelles.readMore10,
      date1: dernieresNouvelles.date1,
      date2: dernieresNouvelles.date2,
      date3: dernieresNouvelles.date3,
      date4: dernieresNouvelles.date4,
      date5: dernieresNouvelles.date5,
      date6: dernieresNouvelles.date6,
      date7: dernieresNouvelles.date7,
      date8: dernieresNouvelles.date8,
      date9: dernieresNouvelles.date9,
      date10: dernieresNouvelles.date10
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
    localStorage.removeItem("isNewDernieresNouvelles");
    window.history.back();
  }

  back(): void {
    this.location.back()
    localStorage.removeItem("isNewDernieresNouvelles");
  }


  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  save(): void {
    this.isSaving = true;
    const dernieresNouvelles = this.createFromForm();
    if (dernieresNouvelles.id !== undefined) {
      localStorage.removeItem("isNewDernieresNouvelles");
      this.subscribeToSaveResponse(this.dernieresNouvellesService.update(dernieresNouvelles));
    } else {
      localStorage.removeItem("isNewDernieresNouvelles");
      this.subscribeToSaveResponse(this.dernieresNouvellesService.create(dernieresNouvelles));
    }
  }


  private createFromForm(): IDernieresNouvelles {
    return {
      ...new DernieresNouvelles(),
      id: this.editForm.get(['id'])!.value,
      titreFr: this.editForm.get(['titreFr'])!.value,
      titreEn: this.editForm.get(['titreEn'])!.value,
      titreGer: this.editForm.get(['titreGer'])!.value,
      titreSw: this.editForm.get(['titreSw'])!.value,
      sousTitreFr: this.editForm.get(['sousTitreFr'])!.value,
      sousTitreEn: this.editForm.get(['sousTitreEn'])!.value,
      sousTitreGer: this.editForm.get(['sousTitreGer'])!.value,
      sousTitreSw: this.editForm.get(['sousTitreSw'])!.value,
      titreSlide1Fr: this.editForm.get(['titreSlide1Fr'])!.value,
      titreSlide1En: this.editForm.get(['titreSlide1En'])!.value,
      titreSlide1Ger: this.editForm.get(['titreSlide1Ger'])!.value,
      titreSlide1Sw: this.editForm.get(['titreSlide1Sw'])!.value,
      titreSlide2Fr: this.editForm.get(['titreSlide2Fr'])!.value,
      titreSlide2En: this.editForm.get(['titreSlide2En'])!.value,
      titreSlide2Ger: this.editForm.get(['titreSlide2Ger'])!.value,
      titreSlide2Sw: this.editForm.get(['titreSlide2Sw'])!.value,
      titreSlide3Fr: this.editForm.get(['titreSlide3Fr'])!.value,
      titreSlide3En: this.editForm.get(['titreSlide3En'])!.value,
      titreSlide3Ger: this.editForm.get(['titreSlide3Ger'])!.value,
      titreSlide3Sw: this.editForm.get(['titreSlide3Sw'])!.value,
      titreSlide4Fr: this.editForm.get(['titreSlide4Fr'])!.value,
      titreSlide4En: this.editForm.get(['titreSlide4En'])!.value,
      titreSlide4Ger: this.editForm.get(['titreSlide4Ger'])!.value,
      titreSlide4Sw: this.editForm.get(['titreSlide4Sw'])!.value,
      titreSlide5Fr: this.editForm.get(['titreSlide5Fr'])!.value,
      titreSlide5En: this.editForm.get(['titreSlide5En'])!.value,
      titreSlide5Ger: this.editForm.get(['titreSlide5Ger'])!.value,
      titreSlide5Sw: this.editForm.get(['titreSlide5Sw'])!.value,
      titreSlide6Fr: this.editForm.get(['titreSlide6Fr'])!.value,
      titreSlide6En: this.editForm.get(['titreSlide6En'])!.value,
      titreSlide6Ger: this.editForm.get(['titreSlide6Ger'])!.value,
      titreSlide6Sw: this.editForm.get(['titreSlide6Sw'])!.value,
      titreSlide7Fr: this.editForm.get(['titreSlide7Fr'])!.value,
      titreSlide7En: this.editForm.get(['titreSlide7En'])!.value,
      titreSlide7Ger: this.editForm.get(['titreSlide7Ger'])!.value,
      titreSlide7Sw: this.editForm.get(['titreSlide7Sw'])!.value,
      titreSlide8Fr: this.editForm.get(['titreSlide8Fr'])!.value,
      titreSlide8En: this.editForm.get(['titreSlide8En'])!.value,
      titreSlide8Ger: this.editForm.get(['titreSlide8Ger'])!.value,
      titreSlide8Sw: this.editForm.get(['titreSlide8Sw'])!.value,
      titreSlide9Fr: this.editForm.get(['titreSlide9Fr'])!.value,
      titreSlide9En: this.editForm.get(['titreSlide9En'])!.value,
      titreSlide9Ger: this.editForm.get(['titreSlide9Ger'])!.value,
      titreSlide9Sw: this.editForm.get(['titreSlide9Sw'])!.value,
      titreSlide1OFr: this.editForm.get(['titreSlide1OFr'])!.value,
      titreSlide1OEn: this.editForm.get(['titreSlide1OEn'])!.value,
      titreSlide1OGer: this.editForm.get(['titreSlide1OGer'])!.value,
      titreSlide1OSw: this.editForm.get(['titreSlide1OSw'])!.value,
      textSlide1Fr: this.editForm.get(['textSlide1Fr'])!.value,
      textSlide1En: this.editForm.get(['textSlide1En'])!.value,
      textSlide1Ger: this.editForm.get(['textSlide1Ger'])!.value,
      textSlide1Sw: this.editForm.get(['textSlide1Sw'])!.value,
      textSlide2Fr: this.editForm.get(['textSlide2Fr'])!.value,
      textSlide2En: this.editForm.get(['textSlide2En'])!.value,
      textSlide2Ger: this.editForm.get(['textSlide2Ger'])!.value,
      textSlide2Sw: this.editForm.get(['textSlide2Sw'])!.value,
      textSlide3Fr: this.editForm.get(['textSlide3Fr'])!.value,
      textSlide3En: this.editForm.get(['textSlide3En'])!.value,
      textSlide3Ger: this.editForm.get(['textSlide3Ger'])!.value,
      textSlide3Sw: this.editForm.get(['textSlide3Sw'])!.value,
      textSlide4Fr: this.editForm.get(['textSlide4Fr'])!.value,
      textSlide4En: this.editForm.get(['textSlide4En'])!.value,
      textSlide4Ger: this.editForm.get(['textSlide4Ger'])!.value,
      textSlide4Sw: this.editForm.get(['textSlide4Sw'])!.value,
      textSlide5Fr: this.editForm.get(['textSlide5Fr'])!.value,
      textSlide5En: this.editForm.get(['textSlide5En'])!.value,
      textSlide5Ger: this.editForm.get(['textSlide5Ger'])!.value,
      textSlide5Sw: this.editForm.get(['textSlide5Sw'])!.value,
      textSlide6Fr: this.editForm.get(['textSlide6Fr'])!.value,
      textSlide6En: this.editForm.get(['textSlide6En'])!.value,
      textSlide6Ger: this.editForm.get(['textSlide6Ger'])!.value,
      textSlide6Sw: this.editForm.get(['textSlide6Sw'])!.value,
      textSlide7Fr: this.editForm.get(['textSlide7Fr'])!.value,
      textSlide7En: this.editForm.get(['textSlide7En'])!.value,
      textSlide7Ger: this.editForm.get(['textSlide7Ger'])!.value,
      textSlide7Sw: this.editForm.get(['textSlide7Sw'])!.value,
      textSlide8Fr: this.editForm.get(['textSlide8Fr'])!.value,
      textSlide8En: this.editForm.get(['textSlide8En'])!.value,
      textSlide8Ger: this.editForm.get(['textSlide8Ger'])!.value,
      textSlide8Sw: this.editForm.get(['textSlide8Sw'])!.value,
      textSlide9Fr: this.editForm.get(['textSlide9Fr'])!.value,
      textSlide9En: this.editForm.get(['textSlide9En'])!.value,
      textSlide9Ger: this.editForm.get(['textSlide9Ger'])!.value,
      textSlide9Sw: this.editForm.get(['textSlide9Sw'])!.value,
      textSlide10Fr: this.editForm.get(['textSlide10Fr'])!.value,
      textSlide10En: this.editForm.get(['textSlide10En'])!.value,
      textSlide10Ger: this.editForm.get(['textSlide10Ger'])!.value,
      textSlide10Sw: this.editForm.get(['textSlide10Sw'])!.value,
      imageSlide1ContentType: this.editForm.get(['imageSlide1ContentType'])!.value,
      imageSlide1: this.editForm.get(['imageSlide1'])!.value,
      imageSlide2ContentType: this.editForm.get(['imageSlide2ContentType'])!.value,
      imageSlide2: this.editForm.get(['imageSlide2'])!.value,
      imageSlide3ContentType: this.editForm.get(['imageSlide3ContentType'])!.value,
      imageSlide3: this.editForm.get(['imageSlide3'])!.value,
      imageSlide4ContentType: this.editForm.get(['imageSlide4ContentType'])!.value,
      imageSlide4: this.editForm.get(['imageSlide4'])!.value,
      imageSlide5ContentType: this.editForm.get(['imageSlide5ContentType'])!.value,
      imageSlide5: this.editForm.get(['imageSlide5'])!.value,
      imageSlide6ContentType: this.editForm.get(['imageSlide6ContentType'])!.value,
      imageSlide6: this.editForm.get(['imageSlide6'])!.value,
      imageSlide7ContentType: this.editForm.get(['imageSlide7ContentType'])!.value,
      imageSlide7: this.editForm.get(['imageSlide7'])!.value,
      imageSlide8ContentType: this.editForm.get(['imageSlide8ContentType'])!.value,
      imageSlide8: this.editForm.get(['imageSlide8'])!.value,
      imageSlide9ContentType: this.editForm.get(['imageSlide9ContentType'])!.value,
      imageSlide9: this.editForm.get(['imageSlide9'])!.value,
      imageSlide10ContentType: this.editForm.get(['imageSlide10ContentType'])!.value,
      imageSlide10: this.editForm.get(['imageSlide10'])!.value,
      readMore1: this.editForm.get(['readMore1'])!.value,
      readMore2: this.editForm.get(['readMore2'])!.value,
      readMore3: this.editForm.get(['readMore3'])!.value,
      readMore4: this.editForm.get(['readMore4'])!.value,
      readMore5: this.editForm.get(['readMore5'])!.value,
      readMore6: this.editForm.get(['readMore6'])!.value,
      readMore7: this.editForm.get(['readMore7'])!.value,
      readMore8: this.editForm.get(['readMore8'])!.value,
      readMore9: this.editForm.get(['readMore9'])!.value,
      readMore10: this.editForm.get(['readMore10'])!.value,
      date1: this.editForm.get(['date1'])!.value,
      date2: this.editForm.get(['date2'])!.value,
      date3: this.editForm.get(['date3'])!.value,
      date4: this.editForm.get(['date4'])!.value,
      date5: this.editForm.get(['date5'])!.value,
      date6: this.editForm.get(['date6'])!.value,
      date7: this.editForm.get(['date7'])!.value,
      date8: this.editForm.get(['date8'])!.value,
      date9: this.editForm.get(['date9'])!.value,
      date10: this.editForm.get(['date10'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDernieresNouvelles>>): void {
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
