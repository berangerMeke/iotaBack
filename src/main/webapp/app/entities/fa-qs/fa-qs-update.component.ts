import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';
import {TransfertDataService} from '../../core/services/transfert-data.service'

import { IFAQs, FAQs } from 'app/shared/model/fa-qs.model';
import { FAQsService } from './fa-qs.service';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';

@Component({
  selector: 'jhi-fa-qs-update',
  templateUrl: './fa-qs-update.component.html',
  styleUrls: ['./fa-qs-update.scss']
})
export class FAQsUpdateComponent implements OnInit {
  isSaving = false;
  eltChoisi : any;

  fAQs :any = [];

  isFAQsNoExist: any;

  public Editor = ClassicEditor;

  editForm = this.fb.group({
    id: [],
    titreFr: ['', Validators.required],
    titreEn: ['', Validators.required],
    titreGer: ['', Validators.required],
    titreSw: ['', Validators.required],
    sousTitreFr: [],
    sousTitreEn: [],
    sousTitreGer: [],
    sousTitreSw: [],
    titreAccordion1Fr: ['', Validators.required],
    titreAccordion1En: ['', Validators.required],
    titreAccordion1Gr: ['', Validators.required],
    titreAccordion1Sw: ['', Validators.required],
    titreAccordion2Fr: ['', Validators.required],
    titreAccordion2En: ['', Validators.required],
    titreAccordion2Ger: ['', Validators.required],
    titreAccordion2Sw: ['', Validators.required],
    titreAccordion3Fr: ['', Validators.required],
    titreAccordion3En: ['', Validators.required],
    titreAccordion3Ger: ['', Validators.required],
    titreAccordion3Sw: ['', Validators.required],
    titreAccordion4Fr: ['', Validators.required],
    titreAccordion4En: ['', Validators.required],
    titreAccordion4Ger: ['', Validators.required],
    titreAccordion4Sw: ['', Validators.required],
    titreAccordion5Fr: ['', Validators.required],
    titreAccordion5En: ['', Validators.required],
    titreAccordion5Ger: ['', Validators.required],
    titreAccordion5Sw: ['', Validators.required],
    titreAccordion6Fr: ['', Validators.required],
    titreAccordion6En: ['', Validators.required],
    titreAccordion6Ger: ['', Validators.required],
    titreAccordion6Sw: ['', Validators.required],
    titreAccordion7Fr: ['', Validators.required],
    titreAccordion7En: ['', Validators.required],
    titreAccordion7Ger: ['', Validators.required],
    titreAccordion7Sw: ['', Validators.required],
    titreAccordion8Fr: ['', Validators.required],
    titreAccordion8En: ['', Validators.required],
    titreAccordion8Ger: ['', Validators.required],
    titreAccordion8Sw: ['', Validators.required],
    titreAccordion9Fr: [],
    titreAccordion9En: [],
    titreAccordion9Ger: [],
    titreAccordion9Sw: [],
    titreAccordion10Fr: [],
    titreAccordion10En: [],
    titreAccordion10Ger: [],
    titreAccordion10Sw: [],
    textAccordion1Fr: [],
    textAccordion1En: [],
    textAccordion1Ger: [],
    textAccordion1Sw: [],
    textAccordion2Fr: [],
    textAccordion2En: [],
    textAccordion2Ger: [],
    textAccordion2Sw: [],
    textAccordion3Fr: [],
    textAccordion3En: [],
    textAccordion3Ger: [],
    textAccordion3Sw: [],
    textAccordion4Fr: [],
    textAccordion4En: [],
    textAccordion4Ger: [],
    textAccordion4Sw: [],
    textAccordion5Fr: [],
    textAccordion5En: [],
    textAccordion5Ger: [],
    textAccordion5Sw: [],
    textAccordion6Fr: [],
    textAccordion6En: [],
    textAccordion6Ger: [],
    textAccordion6Sw: [],
    textAccordion7Fr: [],
    textAccordion7En: [],
    textAccordion7Ger: [],
    textAccordion7Sw: [],
    textAccordion8Fr: [],
    textAccordion8En: [],
    textAccordion8Ger: [],
    textAccordion8Sw: [],
    textAccordion9Fr: [],
    textAccordion9En: [],
    textAccordion9Ger: [],
    textAccordion9Sw: [],
    textAccordion10Fr: [],
    textAccordion10En: [],
    textAccordion10Ger: [],
    textAccordion10Sw: []
  });

  constructor(protected fAQsService: FAQsService, 
    public transfertDataService: TransfertDataService, 
    private location: Location,
    protected activatedRoute: ActivatedRoute, 
    private fb: FormBuilder) 
    {
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
    this.isFAQsNoExist = localStorage.getItem('isNewFAQs'); 
    this.eltChoisi = this.transfertDataService.getData();
    this.activatedRoute.data.subscribe(({ fAQs }) => {
      this.updateForm(fAQs);
      this.fAQs.push(fAQs);
     // console.log(this.fAQs);
    });
  }

  updateForm(fAQs: IFAQs): void {
    this.editForm.patchValue({
      id: fAQs.id,
      titreFr: fAQs.titreFr,
      titreEn: fAQs.titreEn,
      titreGer: fAQs.titreGer,
      titreSw: fAQs.titreSw,
      sousTitreFr: fAQs.sousTitreFr,
      sousTitreEn: fAQs.sousTitreEn,
      sousTitreGer: fAQs.sousTitreGer,
      sousTitreSw: fAQs.sousTitreSw,
      titreAccordion1Fr: fAQs.titreAccordion1Fr,
      titreAccordion1En: fAQs.titreAccordion1En,
      titreAccordion1Gr: fAQs.titreAccordion1Gr,
      titreAccordion1Sw: fAQs.titreAccordion1Sw,
      titreAccordion2Fr: fAQs.titreAccordion2Fr,
      titreAccordion2En: fAQs.titreAccordion2En,
      titreAccordion2Ger: fAQs.titreAccordion2Ger,
      titreAccordion2Sw: fAQs.titreAccordion2Sw,
      titreAccordion3Fr: fAQs.titreAccordion3Fr,
      titreAccordion3En: fAQs.titreAccordion3En,
      titreAccordion3Ger: fAQs.titreAccordion3Ger,
      titreAccordion3Sw: fAQs.titreAccordion3Sw,
      titreAccordion4Fr: fAQs.titreAccordion4Fr,
      titreAccordion4En: fAQs.titreAccordion4En,
      titreAccordion4Ger: fAQs.titreAccordion4Ger,
      titreAccordion4Sw: fAQs.titreAccordion4Sw,
      titreAccordion5Fr: fAQs.titreAccordion5Fr,
      titreAccordion5En: fAQs.titreAccordion5En,
      titreAccordion5Ger: fAQs.titreAccordion5Ger,
      titreAccordion5Sw: fAQs.titreAccordion5Sw,
      titreAccordion6Fr: fAQs.titreAccordion6Fr,
      titreAccordion6En: fAQs.titreAccordion6En,
      titreAccordion6Ger: fAQs.titreAccordion6Ger,
      titreAccordion6Sw: fAQs.titreAccordion6Sw,
      titreAccordion7Fr: fAQs.titreAccordion7Fr,
      titreAccordion7En: fAQs.titreAccordion7En,
      titreAccordion7Ger: fAQs.titreAccordion7Ger,
      titreAccordion7Sw: fAQs.titreAccordion7Sw,
      titreAccordion8Fr: fAQs.titreAccordion8Fr,
      titreAccordion8En: fAQs.titreAccordion8En,
      titreAccordion8Ger: fAQs.titreAccordion8Ger,
      titreAccordion8Sw: fAQs.titreAccordion8Sw,
      titreAccordion9Fr: fAQs.titreAccordion9Fr,
      titreAccordion9En: fAQs.titreAccordion9En,
      titreAccordion9Ger: fAQs.titreAccordion9Ger,
      titreAccordion9Sw: fAQs.titreAccordion9Sw,
      titreAccordion10Fr: fAQs.titreAccordion10Fr,
      titreAccordion10En: fAQs.titreAccordion10En,
      titreAccordion10Ger: fAQs.titreAccordion10Ger,
      titreAccordion10Sw: fAQs.titreAccordion10Sw,
      textAccordion1Fr: fAQs.textAccordion1Fr,
      textAccordion1En: fAQs.textAccordion1En,
      textAccordion1Ger: fAQs.textAccordion1Ger,
      textAccordion1Sw: fAQs.textAccordion1Sw,
      textAccordion2Fr: fAQs.textAccordion2Fr,
      textAccordion2En: fAQs.textAccordion2En,
      textAccordion2Ger: fAQs.textAccordion2Ger,
      textAccordion2Sw: fAQs.textAccordion2Sw,
      textAccordion3Fr: fAQs.textAccordion3Fr,
      textAccordion3En: fAQs.textAccordion3En,
      textAccordion3Ger: fAQs.textAccordion3Ger,
      textAccordion3Sw: fAQs.textAccordion3Sw,
      textAccordion4Fr: fAQs.textAccordion4Fr,
      textAccordion4En: fAQs.textAccordion4En,
      textAccordion4Ger: fAQs.textAccordion4Ger,
      textAccordion4Sw: fAQs.textAccordion4Sw,
      textAccordion5Fr: fAQs.textAccordion5Fr,
      textAccordion5En: fAQs.textAccordion5En,
      textAccordion5Ger: fAQs.textAccordion5Ger,
      textAccordion5Sw: fAQs.textAccordion5Sw,
      textAccordion6Fr: fAQs.textAccordion6Fr,
      textAccordion6En: fAQs.textAccordion6En,
      textAccordion6Ger: fAQs.textAccordion6Ger,
      textAccordion6Sw: fAQs.textAccordion6Sw,
      textAccordion7Fr: fAQs.textAccordion7Fr,
      textAccordion7En: fAQs.textAccordion7En,
      textAccordion7Ger: fAQs.textAccordion7Ger,
      textAccordion7Sw: fAQs.textAccordion7Sw,
      textAccordion8Fr: fAQs.textAccordion8Fr,
      textAccordion8En: fAQs.textAccordion8En,
      textAccordion8Ger: fAQs.textAccordion8Ger,
      textAccordion8Sw: fAQs.textAccordion8Sw,
      textAccordion9Fr: fAQs.textAccordion9Fr,
      textAccordion9En: fAQs.textAccordion9En,
      textAccordion9Ger: fAQs.textAccordion9Ger,
      textAccordion9Sw: fAQs.textAccordion9Sw,
      textAccordion10Fr: fAQs.textAccordion10Fr,
      textAccordion10En: fAQs.textAccordion10En,
      textAccordion10Ger: fAQs.textAccordion10Ger,
      textAccordion10Sw: fAQs.textAccordion10Sw
    });
  }

  previousState(): void {
    localStorage.removeItem("isNewFAQs");
    window.history.back();
  }

  back(): void {
    this.location.back()
    localStorage.removeItem("isNewFAQs");
  }


  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  save(): void {
    this.isSaving = true;
    const fAQs = this.createFromForm();
    if (fAQs.id !== undefined) {
      localStorage.removeItem("isNewFAQs");
      this.subscribeToSaveResponse(this.fAQsService.update(fAQs));
    } else {
      localStorage.removeItem("isNewFAQs");
      this.subscribeToSaveResponse(this.fAQsService.create(fAQs));
    }
  }

  private createFromForm(): IFAQs {
    return {
      ...new FAQs(),
      id: this.editForm.get(['id'])!.value,
      titreFr: this.editForm.get(['titreFr'])!.value,
      titreEn: this.editForm.get(['titreEn'])!.value,
      titreGer: this.editForm.get(['titreGer'])!.value,
      titreSw: this.editForm.get(['titreSw'])!.value,
      sousTitreFr: this.editForm.get(['sousTitreFr'])!.value,
      sousTitreEn: this.editForm.get(['sousTitreEn'])!.value,
      sousTitreGer: this.editForm.get(['sousTitreGer'])!.value,
      sousTitreSw: this.editForm.get(['sousTitreSw'])!.value,
      titreAccordion1Fr: this.editForm.get(['titreAccordion1Fr'])!.value,
      titreAccordion1En: this.editForm.get(['titreAccordion1En'])!.value,
      titreAccordion1Gr: this.editForm.get(['titreAccordion1Gr'])!.value,
      titreAccordion1Sw: this.editForm.get(['titreAccordion1Sw'])!.value,
      titreAccordion2Fr: this.editForm.get(['titreAccordion2Fr'])!.value,
      titreAccordion2En: this.editForm.get(['titreAccordion2En'])!.value,
      titreAccordion2Ger: this.editForm.get(['titreAccordion2Ger'])!.value,
      titreAccordion2Sw: this.editForm.get(['titreAccordion2Sw'])!.value,
      titreAccordion3Fr: this.editForm.get(['titreAccordion3Fr'])!.value,
      titreAccordion3En: this.editForm.get(['titreAccordion3En'])!.value,
      titreAccordion3Ger: this.editForm.get(['titreAccordion3Ger'])!.value,
      titreAccordion3Sw: this.editForm.get(['titreAccordion3Sw'])!.value,
      titreAccordion4Fr: this.editForm.get(['titreAccordion4Fr'])!.value,
      titreAccordion4En: this.editForm.get(['titreAccordion4En'])!.value,
      titreAccordion4Ger: this.editForm.get(['titreAccordion4Ger'])!.value,
      titreAccordion4Sw: this.editForm.get(['titreAccordion4Sw'])!.value,
      titreAccordion5Fr: this.editForm.get(['titreAccordion5Fr'])!.value,
      titreAccordion5En: this.editForm.get(['titreAccordion5En'])!.value,
      titreAccordion5Ger: this.editForm.get(['titreAccordion5Ger'])!.value,
      titreAccordion5Sw: this.editForm.get(['titreAccordion5Sw'])!.value,
      titreAccordion6Fr: this.editForm.get(['titreAccordion6Fr'])!.value,
      titreAccordion6En: this.editForm.get(['titreAccordion6En'])!.value,
      titreAccordion6Ger: this.editForm.get(['titreAccordion6Ger'])!.value,
      titreAccordion6Sw: this.editForm.get(['titreAccordion6Sw'])!.value,
      titreAccordion7Fr: this.editForm.get(['titreAccordion7Fr'])!.value,
      titreAccordion7En: this.editForm.get(['titreAccordion7En'])!.value,
      titreAccordion7Ger: this.editForm.get(['titreAccordion7Ger'])!.value,
      titreAccordion7Sw: this.editForm.get(['titreAccordion7Sw'])!.value,
      titreAccordion8Fr: this.editForm.get(['titreAccordion8Fr'])!.value,
      titreAccordion8En: this.editForm.get(['titreAccordion8En'])!.value,
      titreAccordion8Ger: this.editForm.get(['titreAccordion8Ger'])!.value,
      titreAccordion8Sw: this.editForm.get(['titreAccordion8Sw'])!.value,
      titreAccordion9Fr: this.editForm.get(['titreAccordion9Fr'])!.value,
      titreAccordion9En: this.editForm.get(['titreAccordion9En'])!.value,
      titreAccordion9Ger: this.editForm.get(['titreAccordion9Ger'])!.value,
      titreAccordion9Sw: this.editForm.get(['titreAccordion9Sw'])!.value,
      titreAccordion10Fr: this.editForm.get(['titreAccordion10Fr'])!.value,
      titreAccordion10En: this.editForm.get(['titreAccordion10En'])!.value,
      titreAccordion10Ger: this.editForm.get(['titreAccordion10Ger'])!.value,
      titreAccordion10Sw: this.editForm.get(['titreAccordion10Sw'])!.value,
      textAccordion1Fr: this.editForm.get(['textAccordion1Fr'])!.value,
      textAccordion1En: this.editForm.get(['textAccordion1En'])!.value,
      textAccordion1Ger: this.editForm.get(['textAccordion1Ger'])!.value,
      textAccordion1Sw: this.editForm.get(['textAccordion1Sw'])!.value,
      textAccordion2Fr: this.editForm.get(['textAccordion2Fr'])!.value,
      textAccordion2En: this.editForm.get(['textAccordion2En'])!.value,
      textAccordion2Ger: this.editForm.get(['textAccordion2Ger'])!.value,
      textAccordion2Sw: this.editForm.get(['textAccordion2Sw'])!.value,
      textAccordion3Fr: this.editForm.get(['textAccordion3Fr'])!.value,
      textAccordion3En: this.editForm.get(['textAccordion3En'])!.value,
      textAccordion3Ger: this.editForm.get(['textAccordion3Ger'])!.value,
      textAccordion3Sw: this.editForm.get(['textAccordion3Sw'])!.value,
      textAccordion4Fr: this.editForm.get(['textAccordion4Fr'])!.value,
      textAccordion4En: this.editForm.get(['textAccordion4En'])!.value,
      textAccordion4Ger: this.editForm.get(['textAccordion4Ger'])!.value,
      textAccordion4Sw: this.editForm.get(['textAccordion4Sw'])!.value,
      textAccordion5Fr: this.editForm.get(['textAccordion5Fr'])!.value,
      textAccordion5En: this.editForm.get(['textAccordion5En'])!.value,
      textAccordion5Ger: this.editForm.get(['textAccordion5Ger'])!.value,
      textAccordion5Sw: this.editForm.get(['textAccordion5Sw'])!.value,
      textAccordion6Fr: this.editForm.get(['textAccordion6Fr'])!.value,
      textAccordion6En: this.editForm.get(['textAccordion6En'])!.value,
      textAccordion6Ger: this.editForm.get(['textAccordion6Ger'])!.value,
      textAccordion6Sw: this.editForm.get(['textAccordion6Sw'])!.value,
      textAccordion7Fr: this.editForm.get(['textAccordion7Fr'])!.value,
      textAccordion7En: this.editForm.get(['textAccordion7En'])!.value,
      textAccordion7Ger: this.editForm.get(['textAccordion7Ger'])!.value,
      textAccordion7Sw: this.editForm.get(['textAccordion7Sw'])!.value,
      textAccordion8Fr: this.editForm.get(['textAccordion8Fr'])!.value,
      textAccordion8En: this.editForm.get(['textAccordion8En'])!.value,
      textAccordion8Ger: this.editForm.get(['textAccordion8Ger'])!.value,
      textAccordion8Sw: this.editForm.get(['textAccordion8Sw'])!.value,
      textAccordion9Fr: this.editForm.get(['textAccordion9Fr'])!.value,
      textAccordion9En: this.editForm.get(['textAccordion9En'])!.value,
      textAccordion9Ger: this.editForm.get(['textAccordion9Ger'])!.value,
      textAccordion9Sw: this.editForm.get(['textAccordion9Sw'])!.value,
      textAccordion10Fr: this.editForm.get(['textAccordion10Fr'])!.value,
      textAccordion10En: this.editForm.get(['textAccordion10En'])!.value,
      textAccordion10Ger: this.editForm.get(['textAccordion10Ger'])!.value,
      textAccordion10Sw: this.editForm.get(['textAccordion10Sw'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IFAQs>>): void {
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
