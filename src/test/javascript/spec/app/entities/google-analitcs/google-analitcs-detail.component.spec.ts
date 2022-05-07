import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { GoogleAnalitcsDetailComponent } from 'app/entities/google-analitcs/google-analitcs-detail.component';
import { GoogleAnalitcs } from 'app/shared/model/google-analitcs.model';

describe('Component Tests', () => {
  describe('GoogleAnalitcs Management Detail Component', () => {
    let comp: GoogleAnalitcsDetailComponent;
    let fixture: ComponentFixture<GoogleAnalitcsDetailComponent>;
    const route = ({ data: of({ googleAnalitcs: new GoogleAnalitcs(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [IotaOrignAdminTestModule],
        declarations: [GoogleAnalitcsDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(GoogleAnalitcsDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(GoogleAnalitcsDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load googleAnalitcs on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.googleAnalitcs).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
