import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IDernieresNouvelles, DernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';
import { DernieresNouvellesService } from './dernieres-nouvelles.service';

@Component({
  selector: 'jhi-dernieres-nouvelles-update',
  templateUrl: './dernieres-nouvelles-update.component.html'
})
export class DernieresNouvellesUpdateComponent implements OnInit {
  isSaving = false;

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
    textSlide9En: []
  });

  constructor(
    protected dernieresNouvellesService: DernieresNouvellesService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
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
      textSlide9En: dernieresNouvelles.textSlide9En
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const dernieresNouvelles = this.createFromForm();
    if (dernieresNouvelles.id !== undefined) {
      this.subscribeToSaveResponse(this.dernieresNouvellesService.update(dernieresNouvelles));
    } else {
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
      textSlide9En: this.editForm.get(['textSlide9En'])!.value
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
