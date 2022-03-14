import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { AccueilDetailComponent } from 'app/entities/accueil/accueil-detail.component';
import { Accueil } from 'app/shared/model/accueil.model';

describe('Component Tests', () => {
  describe('Accueil Management Detail Component', () => {
    let comp: AccueilDetailComponent;
    let fixture: ComponentFixture<AccueilDetailComponent>;
    let dataUtils: JhiDataUtils;
    const route = ({ data: of({ accueil: new Accueil(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [AccueilDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(AccueilDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(AccueilDetailComponent);
      comp = fixture.componentInstance;
      dataUtils = fixture.debugElement.injector.get(JhiDataUtils);
    });

    describe('OnInit', () => {
      it('Should load accueil on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.accueil).toEqual(jasmine.objectContaining({ id: 123 }));
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
