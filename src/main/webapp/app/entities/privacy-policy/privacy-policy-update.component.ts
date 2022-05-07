import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Location } from '@angular/common';

import { IPrivacyPolicy, PrivacyPolicy } from 'app/shared/model/privacy-policy.model';
import {TransfertDataService} from '../../core/services/transfert-data.service';
import { PrivacyPolicyService } from './privacy-policy.service';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';

@Component({
  selector: 'jhi-privacy-policy-update',
  templateUrl: './privacy-policy-update.component.html',
  styleUrls: ['./privacy-policy-update.scss']
})
export class PrivacyPolicyUpdateComponent implements OnInit {
  isSaving = false;

  public Editor = ClassicEditor;
  isPrivacyPolicyNoExist: any;
  eltChoisi: any;


  editForm = this.fb.group({
    id: [],
    titrePrivacyPolicyEn: [],
    titrePrivacyPolicyGer: [],
    titrePrivacyPolicyFr: [],
    titrePrivacyPolicySw: [],
    contenuPrivacyPolicyEn: [null, [Validators.maxLength(7000)]],
    contenuPrivacyPolicyGer: [null, [Validators.maxLength(7000)]],
    contenuPrivacyPolicyFr: [null, [Validators.maxLength(7000)]],
    contenuPrivacyPolicySw: [null, [Validators.maxLength(7000)]]
  });

  constructor(
          protected privacyPolicyService: PrivacyPolicyService, 
          protected activatedRoute: ActivatedRoute,
          public transfertDataService: TransfertDataService, 
          private location: Location,  
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
    this.isPrivacyPolicyNoExist = localStorage.getItem('isNewPrivacyPolicy'); 
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ privacyPolicy }) => {
      this.updateForm(privacyPolicy);
    });
  }

  back(): void {
    this.location.back()
    localStorage.removeItem("isNewPrivacyPolicy");
  }


  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  updateForm(privacyPolicy: IPrivacyPolicy): void {
    this.editForm.patchValue({
      id: privacyPolicy.id,
      titrePrivacyPolicyEn: privacyPolicy.titrePrivacyPolicyEn,
      titrePrivacyPolicyGer: privacyPolicy.titrePrivacyPolicyGer,
      titrePrivacyPolicyFr: privacyPolicy.titrePrivacyPolicyFr,
      titrePrivacyPolicySw: privacyPolicy.titrePrivacyPolicySw,
      contenuPrivacyPolicyEn: privacyPolicy.contenuPrivacyPolicyEn,
      contenuPrivacyPolicyGer: privacyPolicy.contenuPrivacyPolicyGer,
      contenuPrivacyPolicyFr: privacyPolicy.contenuPrivacyPolicyFr,
      contenuPrivacyPolicySw: privacyPolicy.contenuPrivacyPolicySw
    });
  }

  previousState(): void {
    localStorage.removeItem("isNewPrivacyPolicy");
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const privacyPolicy = this.createFromForm();
    if (privacyPolicy.id !== undefined) {
      localStorage.removeItem("isNewPrivacyPolicy");
      this.subscribeToSaveResponse(this.privacyPolicyService.update(privacyPolicy));
    } else {
      localStorage.removeItem("isNewPrivacyPolicy");
      this.subscribeToSaveResponse(this.privacyPolicyService.create(privacyPolicy));
    }
  }

  private createFromForm(): IPrivacyPolicy {
    return {
      ...new PrivacyPolicy(),
      id: this.editForm.get(['id'])!.value,
      titrePrivacyPolicyEn: this.editForm.get(['titrePrivacyPolicyEn'])!.value,
      titrePrivacyPolicyGer: this.editForm.get(['titrePrivacyPolicyGer'])!.value,
      titrePrivacyPolicyFr: this.editForm.get(['titrePrivacyPolicyFr'])!.value,
      titrePrivacyPolicySw: this.editForm.get(['titrePrivacyPolicySw'])!.value,
      contenuPrivacyPolicyEn: this.editForm.get(['contenuPrivacyPolicyEn'])!.value,
      contenuPrivacyPolicyGer: this.editForm.get(['contenuPrivacyPolicyGer'])!.value,
      contenuPrivacyPolicyFr: this.editForm.get(['contenuPrivacyPolicyFr'])!.value,
      contenuPrivacyPolicySw: this.editForm.get(['contenuPrivacyPolicySw'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPrivacyPolicy>>): void {
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
