import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { FooterSectionUpdateComponent } from 'app/entities/footer-section/footer-section-update.component';
import { FooterSectionService } from 'app/entities/footer-section/footer-section.service';
import { FooterSection } from 'app/shared/model/footer-section.model';

describe('Component Tests', () => {
  describe('FooterSection Management Update Component', () => {
    let comp: FooterSectionUpdateComponent;
    let fixture: ComponentFixture<FooterSectionUpdateComponent>;
    let service: FooterSectionService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [FooterSectionUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(FooterSectionUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(FooterSectionUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(FooterSectionService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new FooterSection(123);
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
        const entity = new FooterSection();
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
