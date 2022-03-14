import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { ObjectifsDetailComponent } from 'app/entities/objectifs/objectifs-detail.component';
import { Objectifs } from 'app/shared/model/objectifs.model';

describe('Component Tests', () => {
  describe('Objectifs Management Detail Component', () => {
    let comp: ObjectifsDetailComponent;
    let fixture: ComponentFixture<ObjectifsDetailComponent>;
    let dataUtils: JhiDataUtils;
    const route = ({ data: of({ objectifs: new Objectifs(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [ObjectifsDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(ObjectifsDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ObjectifsDetailComponent);
      comp = fixture.componentInstance;
      dataUtils = fixture.debugElement.injector.get(JhiDataUtils);
    });

    describe('OnInit', () => {
      it('Should load objectifs on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.objectifs).toEqual(jasmine.objectContaining({ id: 123 }));
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
