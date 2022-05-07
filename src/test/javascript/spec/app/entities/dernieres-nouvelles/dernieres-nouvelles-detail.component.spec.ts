import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { DernieresNouvellesDetailComponent } from 'app/entities/dernieres-nouvelles/dernieres-nouvelles-detail.component';
import { DernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';

describe('Component Tests', () => {
  describe('DernieresNouvelles Management Detail Component', () => {
    let comp: DernieresNouvellesDetailComponent;
    let fixture: ComponentFixture<DernieresNouvellesDetailComponent>;
    let dataUtils: JhiDataUtils;
    const route = ({ data: of({ dernieresNouvelles: new DernieresNouvelles(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [DernieresNouvellesDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(DernieresNouvellesDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(DernieresNouvellesDetailComponent);
      comp = fixture.componentInstance;
      dataUtils = fixture.debugElement.injector.get(JhiDataUtils);
    });

    describe('OnInit', () => {
      it('Should load dernieresNouvelles on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.dernieresNouvelles).toEqual(jasmine.objectContaining({ id: 123 }));
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
