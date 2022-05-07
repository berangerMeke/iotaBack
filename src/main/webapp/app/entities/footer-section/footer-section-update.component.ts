import { Component, OnInit, ElementRef } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {TransfertDataService} from '../../core/services/transfert-data.service';
import { Observable } from 'rxjs';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';

import { IFooterSection, FooterSection } from 'app/shared/model/footer-section.model';
import { FooterSectionService } from './footer-section.service';
import { AlertError } from 'app/shared/alert/alert-error.model';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';


@Component({
  selector: 'jhi-footer-section-update',
  templateUrl: './footer-section-update.component.html', 
  styleUrls: ['./footer-section-update.scss']
})
export class FooterSectionUpdateComponent implements OnInit {
  isSaving = false;

  isFooterNoExist: any;
  eltChoisi: any;
  public Editor = ClassicEditor;

  editForm = this.fb.group({
    id: [],
    titreEn: [],
    titreGer: [],
    titreFr: [],
    titreSw: [],
    sousTitreEn: [],
    sousTitreGer: [],
    sousTitreFr: [],
    sousTitreSw: [],
    logo: [],
    logoContentType: [],
    texteBouton: [],
    twitterlink: [],
    discordLink: []
  });

  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected footerSectionService: FooterSectionService,
    protected elementRef: ElementRef,
    private location: Location, 
    public transfertDataService: TransfertDataService, 
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {
      ClassicEditor.defaultConfig = {
        toolbar: {
            items: [
                'link',
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
    this.isFooterNoExist = localStorage.getItem('isNewFooter'); 
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ footerSection }) => {
      this.updateForm(footerSection);
    });
  }


  back(): void {
    this.location.back()
    localStorage.removeItem("isNewFooter");
  }


  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }


  updateForm(footerSection: IFooterSection): void {
    this.editForm.patchValue({
      id: footerSection.id,
      titreEn: footerSection.titreEn,
      titreGer: footerSection.titreGer,
      titreFr: footerSection.titreFr,
      titreSw: footerSection.titreSw,
      sousTitreEn: footerSection.sousTitreEn,
      sousTitreGer: footerSection.sousTitreGer,
      sousTitreFr: footerSection.sousTitreFr,
      sousTitreSw: footerSection.sousTitreSw,
      logo: footerSection.logo,
      logoContentType: footerSection.logoContentType,
      texteBouton: footerSection.texteBouton,
      twitterlink: footerSection.twitterlink,
      discordLink: footerSection.discordLink
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
    localStorage.removeItem("isNewFooter");
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const footerSection = this.createFromForm();
    if (footerSection.id !== undefined) {
      localStorage.removeItem("isNewFooter");
      this.subscribeToSaveResponse(this.footerSectionService.update(footerSection));
    } else {
      localStorage.removeItem("isNewFooter");
      this.subscribeToSaveResponse(this.footerSectionService.create(footerSection));
    }
  }

  private createFromForm(): IFooterSection {
    return {
      ...new FooterSection(),
      id: this.editForm.get(['id'])!.value,
      titreEn: this.editForm.get(['titreEn'])!.value,
      titreGer: this.editForm.get(['titreGer'])!.value,
      titreFr: this.editForm.get(['titreFr'])!.value,
      titreSw: this.editForm.get(['titreSw'])!.value,
      sousTitreEn: this.editForm.get(['sousTitreEn'])!.value,
      sousTitreGer: this.editForm.get(['sousTitreGer'])!.value,
      sousTitreFr: this.editForm.get(['sousTitreFr'])!.value,
      sousTitreSw: this.editForm.get(['sousTitreSw'])!.value,
      logoContentType: this.editForm.get(['logoContentType'])!.value,
      logo: this.editForm.get(['logo'])!.value,
      texteBouton: this.editForm.get(['texteBouton'])!.value,
      twitterlink: this.editForm.get(['twitterlink'])!.value,
      discordLink: this.editForm.get(['discordLink'])!.value  
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IFooterSection>>): void {
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
