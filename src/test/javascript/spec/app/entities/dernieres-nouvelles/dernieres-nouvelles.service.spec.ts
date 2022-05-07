import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { DernieresNouvellesService } from 'app/entities/dernieres-nouvelles/dernieres-nouvelles.service';
import { IDernieresNouvelles, DernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';

describe('Service Tests', () => {
  describe('DernieresNouvelles Service', () => {
    let injector: TestBed;
    let service: DernieresNouvellesService;
    let httpMock: HttpTestingController;
    let elemDefault: IDernieresNouvelles;
    let expectedResult: IDernieresNouvelles | IDernieresNouvelles[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(DernieresNouvellesService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new DernieresNouvelles(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a DernieresNouvelles', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new DernieresNouvelles()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a DernieresNouvelles', () => {
        const returnedFromService = Object.assign(
          {
            titreFr: 'BBBBBB',
            titreEn: 'BBBBBB',
            titreGer: 'BBBBBB',
            titreSw: 'BBBBBB',
            sousTitreFr: 'BBBBBB',
            sousTitreEn: 'BBBBBB',
            sousTitreGer: 'BBBBBB',
            sousTitreSw: 'BBBBBB',
            titreSlide1Fr: 'BBBBBB',
            titreSlide1En: 'BBBBBB',
            titreSlide1Ger: 'BBBBBB',
            titreSlide1Sw: 'BBBBBB',
            titreSlide2Fr: 'BBBBBB',
            titreSlide2En: 'BBBBBB',
            titreSlide2Ger: 'BBBBBB',
            titreSlide2Sw: 'BBBBBB',
            titreSlide3Fr: 'BBBBBB',
            titreSlide3En: 'BBBBBB',
            titreSlide3Ger: 'BBBBBB',
            titreSlide3Sw: 'BBBBBB',
            titreSlide4Fr: 'BBBBBB',
            titreSlide4En: 'BBBBBB',
            titreSlide4Ger: 'BBBBBB',
            titreSlide4Sw: 'BBBBBB',
            titreSlide5Fr: 'BBBBBB',
            titreSlide5En: 'BBBBBB',
            titreSlide5Ger: 'BBBBBB',
            titreSlide5Sw: 'BBBBBB',
            titreSlide6Fr: 'BBBBBB',
            titreSlide6En: 'BBBBBB',
            titreSlide6Ger: 'BBBBBB',
            titreSlide6Sw: 'BBBBBB',
            titreSlide7Fr: 'BBBBBB',
            titreSlide7En: 'BBBBBB',
            titreSlide7Ger: 'BBBBBB',
            titreSlide7Sw: 'BBBBBB',
            titreSlide8Fr: 'BBBBBB',
            titreSlide8En: 'BBBBBB',
            titreSlide8Ger: 'BBBBBB',
            titreSlide8Sw: 'BBBBBB',
            titreSlide9Fr: 'BBBBBB',
            titreSlide9En: 'BBBBBB',
            titreSlide9Ger: 'BBBBBB',
            titreSlide9Sw: 'BBBBBB',
            titreSlide1OFr: 'BBBBBB',
            titreSlide1OEn: 'BBBBBB',
            titreSlide1OGer: 'BBBBBB',
            titreSlide1OSw: 'BBBBBB',
            textSlide1Fr: 'BBBBBB',
            textSlide1En: 'BBBBBB',
            textSlide1Ger: 'BBBBBB',
            textSlide1Sw: 'BBBBBB',
            textSlide2Fr: 'BBBBBB',
            textSlide2En: 'BBBBBB',
            textSlide2Ger: 'BBBBBB',
            textSlide2Sw: 'BBBBBB',
            textSlide3Fr: 'BBBBBB',
            textSlide3En: 'BBBBBB',
            textSlide3Ger: 'BBBBBB',
            textSlide3Sw: 'BBBBBB',
            textSlide4Fr: 'BBBBBB',
            textSlide4En: 'BBBBBB',
            textSlide4Ger: 'BBBBBB',
            textSlide4Sw: 'BBBBBB',
            textSlide5Fr: 'BBBBBB',
            textSlide5En: 'BBBBBB',
            textSlide5Ger: 'BBBBBB',
            textSlide5Sw: 'BBBBBB',
            textSlide6Fr: 'BBBBBB',
            textSlide6En: 'BBBBBB',
            textSlide6Ger: 'BBBBBB',
            textSlide6Sw: 'BBBBBB',
            textSlide7Fr: 'BBBBBB',
            textSlide7En: 'BBBBBB',
            textSlide7Ger: 'BBBBBB',
            textSlide7Sw: 'BBBBBB',
            textSlide8Fr: 'BBBBBB',
            textSlide8En: 'BBBBBB',
            textSlide8Ger: 'BBBBBB',
            textSlide8Sw: 'BBBBBB',
            textSlide9Fr: 'BBBBBB',
            textSlide9En: 'BBBBBB',
            textSlide9Ger: 'BBBBBB',
            textSlide9Sw: 'BBBBBB',
            textSlide10Fr: 'BBBBBB',
            textSlide10En: 'BBBBBB',
            textSlide10Ger: 'BBBBBB',
            textSlide10Sw: 'BBBBBB',
            imageSlide1: 'BBBBBB',
            imageSlide2: 'BBBBBB',
            imageSlide3: 'BBBBBB',
            imageSlide4: 'BBBBBB',
            imageSlide5: 'BBBBBB',
            imageSlide6: 'BBBBBB',
            imageSlide7: 'BBBBBB',
            imageSlide8: 'BBBBBB',
            imageSlide9: 'BBBBBB',
            imageSlide10: 'BBBBBB',
            readMore1: 'BBBBBB',
            readMore2: 'BBBBBB',
            readMore3: 'BBBBBB',
            readMore4: 'BBBBBB',
            readMore5: 'BBBBBB',
            readMore6: 'BBBBBB',
            readMore7: 'BBBBBB',
            readMore8: 'BBBBBB',
            readMore9: 'BBBBBB',
            readMore10: 'BBBBBB',
            date1: 'BBBBBB',
            date2: 'BBBBBB',
            date3: 'BBBBBB',
            date4: 'BBBBBB',
            date5: 'BBBBBB',
            date6: 'BBBBBB',
            date7: 'BBBBBB',
            date8: 'BBBBBB',
            date9: 'BBBBBB',
            date10: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of DernieresNouvelles', () => {
        const returnedFromService = Object.assign(
          {
            titreFr: 'BBBBBB',
            titreEn: 'BBBBBB',
            titreGer: 'BBBBBB',
            titreSw: 'BBBBBB',
            sousTitreFr: 'BBBBBB',
            sousTitreEn: 'BBBBBB',
            sousTitreGer: 'BBBBBB',
            sousTitreSw: 'BBBBBB',
            titreSlide1Fr: 'BBBBBB',
            titreSlide1En: 'BBBBBB',
            titreSlide1Ger: 'BBBBBB',
            titreSlide1Sw: 'BBBBBB',
            titreSlide2Fr: 'BBBBBB',
            titreSlide2En: 'BBBBBB',
            titreSlide2Ger: 'BBBBBB',
            titreSlide2Sw: 'BBBBBB',
            titreSlide3Fr: 'BBBBBB',
            titreSlide3En: 'BBBBBB',
            titreSlide3Ger: 'BBBBBB',
            titreSlide3Sw: 'BBBBBB',
            titreSlide4Fr: 'BBBBBB',
            titreSlide4En: 'BBBBBB',
            titreSlide4Ger: 'BBBBBB',
            titreSlide4Sw: 'BBBBBB',
            titreSlide5Fr: 'BBBBBB',
            titreSlide5En: 'BBBBBB',
            titreSlide5Ger: 'BBBBBB',
            titreSlide5Sw: 'BBBBBB',
            titreSlide6Fr: 'BBBBBB',
            titreSlide6En: 'BBBBBB',
            titreSlide6Ger: 'BBBBBB',
            titreSlide6Sw: 'BBBBBB',
            titreSlide7Fr: 'BBBBBB',
            titreSlide7En: 'BBBBBB',
            titreSlide7Ger: 'BBBBBB',
            titreSlide7Sw: 'BBBBBB',
            titreSlide8Fr: 'BBBBBB',
            titreSlide8En: 'BBBBBB',
            titreSlide8Ger: 'BBBBBB',
            titreSlide8Sw: 'BBBBBB',
            titreSlide9Fr: 'BBBBBB',
            titreSlide9En: 'BBBBBB',
            titreSlide9Ger: 'BBBBBB',
            titreSlide9Sw: 'BBBBBB',
            titreSlide1OFr: 'BBBBBB',
            titreSlide1OEn: 'BBBBBB',
            titreSlide1OGer: 'BBBBBB',
            titreSlide1OSw: 'BBBBBB',
            textSlide1Fr: 'BBBBBB',
            textSlide1En: 'BBBBBB',
            textSlide1Ger: 'BBBBBB',
            textSlide1Sw: 'BBBBBB',
            textSlide2Fr: 'BBBBBB',
            textSlide2En: 'BBBBBB',
            textSlide2Ger: 'BBBBBB',
            textSlide2Sw: 'BBBBBB',
            textSlide3Fr: 'BBBBBB',
            textSlide3En: 'BBBBBB',
            textSlide3Ger: 'BBBBBB',
            textSlide3Sw: 'BBBBBB',
            textSlide4Fr: 'BBBBBB',
            textSlide4En: 'BBBBBB',
            textSlide4Ger: 'BBBBBB',
            textSlide4Sw: 'BBBBBB',
            textSlide5Fr: 'BBBBBB',
            textSlide5En: 'BBBBBB',
            textSlide5Ger: 'BBBBBB',
            textSlide5Sw: 'BBBBBB',
            textSlide6Fr: 'BBBBBB',
            textSlide6En: 'BBBBBB',
            textSlide6Ger: 'BBBBBB',
            textSlide6Sw: 'BBBBBB',
            textSlide7Fr: 'BBBBBB',
            textSlide7En: 'BBBBBB',
            textSlide7Ger: 'BBBBBB',
            textSlide7Sw: 'BBBBBB',
            textSlide8Fr: 'BBBBBB',
            textSlide8En: 'BBBBBB',
            textSlide8Ger: 'BBBBBB',
            textSlide8Sw: 'BBBBBB',
            textSlide9Fr: 'BBBBBB',
            textSlide9En: 'BBBBBB',
            textSlide9Ger: 'BBBBBB',
            textSlide9Sw: 'BBBBBB',
            textSlide10Fr: 'BBBBBB',
            textSlide10En: 'BBBBBB',
            textSlide10Ger: 'BBBBBB',
            textSlide10Sw: 'BBBBBB',
            imageSlide1: 'BBBBBB',
            imageSlide2: 'BBBBBB',
            imageSlide3: 'BBBBBB',
            imageSlide4: 'BBBBBB',
            imageSlide5: 'BBBBBB',
            imageSlide6: 'BBBBBB',
            imageSlide7: 'BBBBBB',
            imageSlide8: 'BBBBBB',
            imageSlide9: 'BBBBBB',
            imageSlide10: 'BBBBBB',
            readMore1: 'BBBBBB',
            readMore2: 'BBBBBB',
            readMore3: 'BBBBBB',
            readMore4: 'BBBBBB',
            readMore5: 'BBBBBB',
            readMore6: 'BBBBBB',
            readMore7: 'BBBBBB',
            readMore8: 'BBBBBB',
            readMore9: 'BBBBBB',
            readMore10: 'BBBBBB',
            date1: 'BBBBBB',
            date2: 'BBBBBB',
            date3: 'BBBBBB',
            date4: 'BBBBBB',
            date5: 'BBBBBB',
            date6: 'BBBBBB',
            date7: 'BBBBBB',
            date8: 'BBBBBB',
            date9: 'BBBBBB',
            date10: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a DernieresNouvelles', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
