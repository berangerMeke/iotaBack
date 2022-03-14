import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { AvantagesDetailComponent } from 'app/entities/avantages/avantages-detail.component';
import { Avantages } from 'app/shared/model/avantages.model';

describe('Component Tests', () => {
  describe('Avantages Management Detail Component', () => {
    let comp: AvantagesDetailComponent;
    let fixture: ComponentFixture<AvantagesDetailComponent>;
    let dataUtils: JhiDataUtils;
    const route = ({ data: of({ avantages: new Avantages(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [AvantagesDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(AvantagesDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(AvantagesDetailComponent);
      comp = fixture.componentInstance;
      dataUtils = fixture.debugElement.injector.get(JhiDataUtils);
    });

    describe('OnInit', () => {
      it('Should load avantages on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.avantages).toEqual(jasmine.objectContaining({ id: 123 }));
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
