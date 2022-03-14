import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FAQsService } from 'app/entities/fa-qs/fa-qs.service';
import { IFAQs, FAQs } from 'app/shared/model/fa-qs.model';

describe('Service Tests', () => {
  describe('FAQs Service', () => {
    let injector: TestBed;
    let service: FAQsService;
    let httpMock: HttpTestingController;
    let elemDefault: IFAQs;
    let expectedResult: IFAQs | IFAQs[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(FAQsService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new FAQs(
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

      it('should create a FAQs', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new FAQs()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a FAQs', () => {
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
            titreAccordion1Fr: 'BBBBBB',
            titreAccordion1En: 'BBBBBB',
            titreAccordion1Gr: 'BBBBBB',
            titreAccordion1Sw: 'BBBBBB',
            titreAccordion2Fr: 'BBBBBB',
            titreAccordion2En: 'BBBBBB',
            titreAccordion2Ger: 'BBBBBB',
            titreAccordion2Sw: 'BBBBBB',
            titreAccordion3Fr: 'BBBBBB',
            titreAccordion3En: 'BBBBBB',
            titreAccordion3Ger: 'BBBBBB',
            titreAccordion3Sw: 'BBBBBB',
            titreAccordion4Fr: 'BBBBBB',
            titreAccordion4En: 'BBBBBB',
            titreAccordion4Ger: 'BBBBBB',
            titreAccordion4Sw: 'BBBBBB',
            titreAccordion5Fr: 'BBBBBB',
            titreAccordion5En: 'BBBBBB',
            titreAccordion5Ger: 'BBBBBB',
            titreAccordion5Sw: 'BBBBBB',
            titreAccordion6Fr: 'BBBBBB',
            titreAccordion6En: 'BBBBBB',
            titreAccordion6Ger: 'BBBBBB',
            titreAccordion6Sw: 'BBBBBB',
            titreAccordion7Fr: 'BBBBBB',
            titreAccordion7En: 'BBBBBB',
            titreAccordion7Ger: 'BBBBBB',
            titreAccordion7Sw: 'BBBBBB',
            titreAccordion8Fr: 'BBBBBB',
            titreAccordion8En: 'BBBBBB',
            titreAccordion8Ger: 'BBBBBB',
            titreAccordion8Sw: 'BBBBBB',
            titreAccordion9Fr: 'BBBBBB',
            titreAccordion9En: 'BBBBBB',
            titreAccordion9Ger: 'BBBBBB',
            titreAccordion9Sw: 'BBBBBB',
            titreAccordion10Fr: 'BBBBBB',
            titreAccordion10En: 'BBBBBB',
            titreAccordion10Ger: 'BBBBBB',
            titreAccordion10Sw: 'BBBBBB',
            textAccordion1Fr: 'BBBBBB',
            textAccordion1En: 'BBBBBB',
            textAccordion1Ger: 'BBBBBB',
            textAccordion1Sw: 'BBBBBB',
            textAccordion2Fr: 'BBBBBB',
            textAccordion2En: 'BBBBBB',
            textAccordion2Ger: 'BBBBBB',
            textAccordion2Sw: 'BBBBBB',
            textAccordion3Fr: 'BBBBBB',
            textAccordion3En: 'BBBBBB',
            textAccordion3Ger: 'BBBBBB',
            textAccordion3Sw: 'BBBBBB',
            textAccordion4Fr: 'BBBBBB',
            textAccordion4En: 'BBBBBB',
            textAccordion4Ger: 'BBBBBB',
            textAccordion4Sw: 'BBBBBB',
            textAccordion5Fr: 'BBBBBB',
            textAccordion5En: 'BBBBBB',
            textAccordion5Ger: 'BBBBBB',
            textAccordion5Sw: 'BBBBBB',
            textAccordion6Fr: 'BBBBBB',
            textAccordion6En: 'BBBBBB',
            textAccordion6Ger: 'BBBBBB',
            textAccordion6Sw: 'BBBBBB',
            textAccordion7Fr: 'BBBBBB',
            textAccordion7En: 'BBBBBB',
            textAccordion7Ger: 'BBBBBB',
            textAccordion7Sw: 'BBBBBB',
            textAccordion8Fr: 'BBBBBB',
            textAccordion8En: 'BBBBBB',
            textAccordion8Ger: 'BBBBBB',
            textAccordion8Sw: 'BBBBBB',
            textAccordion9Fr: 'BBBBBB',
            textAccordion9En: 'BBBBBB',
            textAccordion9Ger: 'BBBBBB',
            textAccordion9Sw: 'BBBBBB',
            textAccordion10Fr: 'BBBBBB',
            textAccordion10En: 'BBBBBB',
            textAccordion10Ger: 'BBBBBB',
            textAccordion10Sw: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of FAQs', () => {
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
            titreAccordion1Fr: 'BBBBBB',
            titreAccordion1En: 'BBBBBB',
            titreAccordion1Gr: 'BBBBBB',
            titreAccordion1Sw: 'BBBBBB',
            titreAccordion2Fr: 'BBBBBB',
            titreAccordion2En: 'BBBBBB',
            titreAccordion2Ger: 'BBBBBB',
            titreAccordion2Sw: 'BBBBBB',
            titreAccordion3Fr: 'BBBBBB',
            titreAccordion3En: 'BBBBBB',
            titreAccordion3Ger: 'BBBBBB',
            titreAccordion3Sw: 'BBBBBB',
            titreAccordion4Fr: 'BBBBBB',
            titreAccordion4En: 'BBBBBB',
            titreAccordion4Ger: 'BBBBBB',
            titreAccordion4Sw: 'BBBBBB',
            titreAccordion5Fr: 'BBBBBB',
            titreAccordion5En: 'BBBBBB',
            titreAccordion5Ger: 'BBBBBB',
            titreAccordion5Sw: 'BBBBBB',
            titreAccordion6Fr: 'BBBBBB',
            titreAccordion6En: 'BBBBBB',
            titreAccordion6Ger: 'BBBBBB',
            titreAccordion6Sw: 'BBBBBB',
            titreAccordion7Fr: 'BBBBBB',
            titreAccordion7En: 'BBBBBB',
            titreAccordion7Ger: 'BBBBBB',
            titreAccordion7Sw: 'BBBBBB',
            titreAccordion8Fr: 'BBBBBB',
            titreAccordion8En: 'BBBBBB',
            titreAccordion8Ger: 'BBBBBB',
            titreAccordion8Sw: 'BBBBBB',
            titreAccordion9Fr: 'BBBBBB',
            titreAccordion9En: 'BBBBBB',
            titreAccordion9Ger: 'BBBBBB',
            titreAccordion9Sw: 'BBBBBB',
            titreAccordion10Fr: 'BBBBBB',
            titreAccordion10En: 'BBBBBB',
            titreAccordion10Ger: 'BBBBBB',
            titreAccordion10Sw: 'BBBBBB',
            textAccordion1Fr: 'BBBBBB',
            textAccordion1En: 'BBBBBB',
            textAccordion1Ger: 'BBBBBB',
            textAccordion1Sw: 'BBBBBB',
            textAccordion2Fr: 'BBBBBB',
            textAccordion2En: 'BBBBBB',
            textAccordion2Ger: 'BBBBBB',
            textAccordion2Sw: 'BBBBBB',
            textAccordion3Fr: 'BBBBBB',
            textAccordion3En: 'BBBBBB',
            textAccordion3Ger: 'BBBBBB',
            textAccordion3Sw: 'BBBBBB',
            textAccordion4Fr: 'BBBBBB',
            textAccordion4En: 'BBBBBB',
            textAccordion4Ger: 'BBBBBB',
            textAccordion4Sw: 'BBBBBB',
            textAccordion5Fr: 'BBBBBB',
            textAccordion5En: 'BBBBBB',
            textAccordion5Ger: 'BBBBBB',
            textAccordion5Sw: 'BBBBBB',
            textAccordion6Fr: 'BBBBBB',
            textAccordion6En: 'BBBBBB',
            textAccordion6Ger: 'BBBBBB',
            textAccordion6Sw: 'BBBBBB',
            textAccordion7Fr: 'BBBBBB',
            textAccordion7En: 'BBBBBB',
            textAccordion7Ger: 'BBBBBB',
            textAccordion7Sw: 'BBBBBB',
            textAccordion8Fr: 'BBBBBB',
            textAccordion8En: 'BBBBBB',
            textAccordion8Ger: 'BBBBBB',
            textAccordion8Sw: 'BBBBBB',
            textAccordion9Fr: 'BBBBBB',
            textAccordion9En: 'BBBBBB',
            textAccordion9Ger: 'BBBBBB',
            textAccordion9Sw: 'BBBBBB',
            textAccordion10Fr: 'BBBBBB',
            textAccordion10En: 'BBBBBB',
            textAccordion10Ger: 'BBBBBB',
            textAccordion10Sw: 'BBBBBB'
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

      it('should delete a FAQs', () => {
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
