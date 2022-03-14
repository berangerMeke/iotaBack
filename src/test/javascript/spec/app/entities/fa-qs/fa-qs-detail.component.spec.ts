import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { FAQsDetailComponent } from 'app/entities/fa-qs/fa-qs-detail.component';
import { FAQs } from 'app/shared/model/fa-qs.model';

describe('Component Tests', () => {
  describe('FAQs Management Detail Component', () => {
    let comp: FAQsDetailComponent;
    let fixture: ComponentFixture<FAQsDetailComponent>;
    const route = ({ data: of({ fAQs: new FAQs(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [FAQsDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(FAQsDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(FAQsDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load fAQs on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.fAQs).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
