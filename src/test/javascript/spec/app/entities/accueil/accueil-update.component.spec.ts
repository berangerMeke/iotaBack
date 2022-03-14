import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { AccueilUpdateComponent } from 'app/entities/accueil/accueil-update.component';
import { AccueilService } from 'app/entities/accueil/accueil.service';
import { Accueil } from 'app/shared/model/accueil.model';

describe('Component Tests', () => {
  describe('Accueil Management Update Component', () => {
    let comp: AccueilUpdateComponent;
    let fixture: ComponentFixture<AccueilUpdateComponent>;
    let service: AccueilService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [AccueilUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(AccueilUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(AccueilUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(AccueilService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Accueil(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new Accueil();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
