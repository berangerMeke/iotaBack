import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { PrivacyPolicyUpdateComponent } from 'app/entities/privacy-policy/privacy-policy-update.component';
import { PrivacyPolicyService } from 'app/entities/privacy-policy/privacy-policy.service';
import { PrivacyPolicy } from 'app/shared/model/privacy-policy.model';

describe('Component Tests', () => {
  describe('PrivacyPolicy Management Update Component', () => {
    let comp: PrivacyPolicyUpdateComponent;
    let fixture: ComponentFixture<PrivacyPolicyUpdateComponent>;
    let service: PrivacyPolicyService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [PrivacyPolicyUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(PrivacyPolicyUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(PrivacyPolicyUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(PrivacyPolicyService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new PrivacyPolicy(123);
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
        const entity = new PrivacyPolicy();
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
