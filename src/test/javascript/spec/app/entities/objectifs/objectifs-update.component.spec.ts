import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { ObjectifsUpdateComponent } from 'app/entities/objectifs/objectifs-update.component';
import { ObjectifsService } from 'app/entities/objectifs/objectifs.service';
import { Objectifs } from 'app/shared/model/objectifs.model';

describe('Component Tests', () => {
  describe('Objectifs Management Update Component', () => {
    let comp: ObjectifsUpdateComponent;
    let fixture: ComponentFixture<ObjectifsUpdateComponent>;
    let service: ObjectifsService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [ObjectifsUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(ObjectifsUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ObjectifsUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ObjectifsService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Objectifs(123);
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
        const entity = new Objectifs();
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
