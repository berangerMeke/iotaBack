import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { AProposUpdateComponent } from 'app/entities/a-propos/a-propos-update.component';
import { AProposService } from 'app/entities/a-propos/a-propos.service';
import { APropos } from 'app/shared/model/a-propos.model';

describe('Component Tests', () => {
  describe('APropos Management Update Component', () => {
    let comp: AProposUpdateComponent;
    let fixture: ComponentFixture<AProposUpdateComponent>;
    let service: AProposService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [AProposUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(AProposUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(AProposUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(AProposService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new APropos(123);
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
        const entity = new APropos();
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
