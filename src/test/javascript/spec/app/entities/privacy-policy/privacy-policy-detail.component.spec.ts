import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { PrivacyPolicyDetailComponent } from 'app/entities/privacy-policy/privacy-policy-detail.component';
import { PrivacyPolicy } from 'app/shared/model/privacy-policy.model';

describe('Component Tests', () => {
  describe('PrivacyPolicy Management Detail Component', () => {
    let comp: PrivacyPolicyDetailComponent;
    let fixture: ComponentFixture<PrivacyPolicyDetailComponent>;
    const route = ({ data: of({ privacyPolicy: new PrivacyPolicy(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [PrivacyPolicyDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(PrivacyPolicyDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(PrivacyPolicyDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load privacyPolicy on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.privacyPolicy).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
