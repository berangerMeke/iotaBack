import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { GoogleAnalitcsUpdateComponent } from 'app/entities/google-analitcs/google-analitcs-update.component';
import { GoogleAnalitcsService } from 'app/entities/google-analitcs/google-analitcs.service';
import { GoogleAnalitcs } from 'app/shared/model/google-analitcs.model';

describe('Component Tests', () => {
  describe('GoogleAnalitcs Management Update Component', () => {
    let comp: GoogleAnalitcsUpdateComponent;
    let fixture: ComponentFixture<GoogleAnalitcsUpdateComponent>;
    let service: GoogleAnalitcsService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [GoogleAnalitcsUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(GoogleAnalitcsUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(GoogleAnalitcsUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(GoogleAnalitcsService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new GoogleAnalitcs(123);
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
        const entity = new GoogleAnalitcs();
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
