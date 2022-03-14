import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { DernieresNouvellesUpdateComponent } from 'app/entities/dernieres-nouvelles/dernieres-nouvelles-update.component';
import { DernieresNouvellesService } from 'app/entities/dernieres-nouvelles/dernieres-nouvelles.service';
import { DernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';

describe('Component Tests', () => {
  describe('DernieresNouvelles Management Update Component', () => {
    let comp: DernieresNouvellesUpdateComponent;
    let fixture: ComponentFixture<DernieresNouvellesUpdateComponent>;
    let service: DernieresNouvellesService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [DernieresNouvellesUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(DernieresNouvellesUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DernieresNouvellesUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DernieresNouvellesService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new DernieresNouvelles(123);
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
        const entity = new DernieresNouvelles();
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
