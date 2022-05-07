import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Location } from '@angular/common';

import { IImprint, Imprint } from 'app/shared/model/imprint.model';
import {TransfertDataService} from '../../core/services/transfert-data.service'
import { ImprintService } from './imprint.service';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';

@Component({
  selector: 'jhi-imprint-update',
  templateUrl: './imprint-update.component.html',
  styleUrls: ['./imprint-update.scss']
})
export class ImprintUpdateComponent implements OnInit {
  isSaving = false;

  isImprintNoExist: any;
  eltChoisi : any;

  public Editor = ClassicEditor;

  editForm = this.fb.group({
    id: [],
    titreImprintEn: [],
    titreImprintFr: [],
    titreImprintGer: [],
    titreImprintSw: [],
    contenuImprintEn: [null, [Validators.maxLength(7000)]],
    contenuImprintGer: [null, [Validators.maxLength(7000)]],
    contenuImprintFr: [null, [Validators.maxLength(7000)]],
    contenuImprintSw: [null, [Validators.maxLength(7000)]]
  });

  constructor(protected imprintService: ImprintService, 
              protected activatedRoute: ActivatedRoute,
              private location: Location, 
              public transfertDataService: TransfertDataService, 
              private fb: FormBuilder) {

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
    this.isImprintNoExist = localStorage.getItem('isNewImprint'); 
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ imprint }) => {
      this.updateForm(imprint);
    });
  }

  back(): void {
    this.location.back()
    localStorage.removeItem("isNewImprint");
  }


  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  updateForm(imprint: IImprint): void {
    this.editForm.patchValue({
      id: imprint.id,
      titreImprintEn: imprint.titreImprintEn,
      titreImprintFr: imprint.titreImprintFr,
      titreImprintGer: imprint.titreImprintGer,
      titreImprintSw: imprint.titreImprintSw,
      contenuImprintEn: imprint.contenuImprintEn,
      contenuImprintGer: imprint.contenuImprintGer,
      contenuImprintFr: imprint.contenuImprintFr,
      contenuImprintSw: imprint.contenuImprintSw
    });
  }

  previousState(): void {
    localStorage.removeItem("isNewImprint");
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const imprint = this.createFromForm();
    if (imprint.id !== undefined) {
      localStorage.removeItem("isNewImprint");
      this.subscribeToSaveResponse(this.imprintService.update(imprint));
    } else {
      localStorage.removeItem("isNewImprint");
      this.subscribeToSaveResponse(this.imprintService.create(imprint));
    }
  }

  private createFromForm(): IImprint {
    return {
      ...new Imprint(),
      id: this.editForm.get(['id'])!.value,
      titreImprintEn: this.editForm.get(['titreImprintEn'])!.value,
      titreImprintFr: this.editForm.get(['titreImprintFr'])!.value,
      titreImprintGer: this.editForm.get(['titreImprintGer'])!.value,
      titreImprintSw: this.editForm.get(['titreImprintSw'])!.value,
      contenuImprintEn: this.editForm.get(['contenuImprintEn'])!.value,
      contenuImprintGer: this.editForm.get(['contenuImprintGer'])!.value,
      contenuImprintFr: this.editForm.get(['contenuImprintFr'])!.value,
      contenuImprintSw: this.editForm.get(['contenuImprintSw'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IImprint>>): void {
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
