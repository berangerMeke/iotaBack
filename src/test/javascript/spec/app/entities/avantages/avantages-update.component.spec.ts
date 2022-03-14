import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { AvantagesUpdateComponent } from 'app/entities/avantages/avantages-update.component';
import { AvantagesService } from 'app/entities/avantages/avantages.service';
import { Avantages } from 'app/shared/model/avantages.model';

describe('Component Tests', () => {
  describe('Avantages Management Update Component', () => {
    let comp: AvantagesUpdateComponent;
    let fixture: ComponentFixture<AvantagesUpdateComponent>;
    let service: AvantagesService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [AvantagesUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(AvantagesUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(AvantagesUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(AvantagesService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Avantages(123);
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
        const entity = new Avantages();
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
