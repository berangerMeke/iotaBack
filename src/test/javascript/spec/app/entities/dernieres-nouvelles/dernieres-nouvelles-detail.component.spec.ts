import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { IotaOrignAdminTestModule } from '../../../test.module';
import { DernieresNouvellesDetailComponent } from 'app/entities/dernieres-nouvelles/dernieres-nouvelles-detail.component';
import { DernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';

describe('Component Tests', () => {
  describe('DernieresNouvelles Management Detail Component', () => {
    let comp: DernieresNouvellesDetailComponent;
    let fixture: ComponentFixture<DernieresNouvellesDetailComponent>;
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
    });

    describe('OnInit', () => {
      it('Should load dernieresNouvelles on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.dernieresNouvelles).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
