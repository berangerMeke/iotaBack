import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { FooterSectionDetailComponent } from 'app/entities/footer-section/footer-section-detail.component';
import { FooterSection } from 'app/shared/model/footer-section.model';

describe('Component Tests', () => {
  describe('FooterSection Management Detail Component', () => {
    let comp: FooterSectionDetailComponent;
    let fixture: ComponentFixture<FooterSectionDetailComponent>;
    let dataUtils: JhiDataUtils;
    const route = ({ data: of({ footerSection: new FooterSection(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [FooterSectionDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(FooterSectionDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(FooterSectionDetailComponent);
      comp = fixture.componentInstance;
      dataUtils = fixture.debugElement.injector.get(JhiDataUtils);
    });

    describe('OnInit', () => {
      it('Should load footerSection on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.footerSection).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });

    describe('byteSize', () => {
      it('Should call byteSize from JhiDataUtils', () => {
        // GIVEN
        spyOn(dataUtils, 'byteSize');
        const fakeBase64 = 'fake base64';

        // WHEN
        comp.byteSize(fakeBase64);

        // THEN
        expect(dataUtils.byteSize).toBeCalledWith(fakeBase64);
      });
    });

    describe('openFile', () => {
      it('Should call openFile from JhiDataUtils', () => {
        // GIVEN
        spyOn(dataUtils, 'openFile');
        const fakeContentType = 'fake content type';
        const fakeBase64 = 'fake base64';

        // WHEN
        comp.openFile(fakeContentType, fakeBase64);

        // THEN
        expect(dataUtils.openFile).toBeCalledWith(fakeContentType, fakeBase64);
      });
    });
  });
});
