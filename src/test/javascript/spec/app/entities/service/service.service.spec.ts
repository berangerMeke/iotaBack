import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ServiceService } from 'app/entities/service/service.service';
import { IService, Service } from 'app/shared/model/service.model';

describe('Service Tests', () => {
  describe('Service Service', () => {
    let injector: TestBed;
    let service: ServiceService;
    let httpMock: HttpTestingController;
    let elemDefault: IService;
    let expectedResult: IService | IService[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ServiceService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new Service(
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
        'image/png',
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

      it('should create a Service', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new Service()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Service', () => {
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
            textParagraphe1Fr: 'BBBBBB',
            textParagraphe1En: 'BBBBBB',
            textParagraphe1Ger: 'BBBBBB',
            textParagraphe1Sw: 'BBBBBB',
            textParagraphe2Fr: 'BBBBBB',
            textParagraphe2En: 'BBBBBB',
            textParagraphe2Ger: 'BBBBBB',
            textParagraphe2Sw: 'BBBBBB',
            textParagraphe3Fr: 'BBBBBB',
            textParagraphe3En: 'BBBBBB',
            textParagraphe3Ger: 'BBBBBB',
            textParagraphe3Sw: 'BBBBBB',
            textParagraphe4Fr: 'BBBBBB',
            textParagraphe4En: 'BBBBBB',
            textParagraphe4Ger: 'BBBBBB',
            textParagraphe4Sw: 'BBBBBB',
            textParagraphe5Fr: 'BBBBBB',
            textParagraphe5En: 'BBBBBB',
            textParagraphe5Ger: 'BBBBBB',
            textParagraphe5Sw: 'BBBBBB',
            image: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of Service', () => {
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
            textParagraphe1Fr: 'BBBBBB',
            textParagraphe1En: 'BBBBBB',
            textParagraphe1Ger: 'BBBBBB',
            textParagraphe1Sw: 'BBBBBB',
            textParagraphe2Fr: 'BBBBBB',
            textParagraphe2En: 'BBBBBB',
            textParagraphe2Ger: 'BBBBBB',
            textParagraphe2Sw: 'BBBBBB',
            textParagraphe3Fr: 'BBBBBB',
            textParagraphe3En: 'BBBBBB',
            textParagraphe3Ger: 'BBBBBB',
            textParagraphe3Sw: 'BBBBBB',
            textParagraphe4Fr: 'BBBBBB',
            textParagraphe4En: 'BBBBBB',
            textParagraphe4Ger: 'BBBBBB',
            textParagraphe4Sw: 'BBBBBB',
            textParagraphe5Fr: 'BBBBBB',
            textParagraphe5En: 'BBBBBB',
            textParagraphe5Ger: 'BBBBBB',
            textParagraphe5Sw: 'BBBBBB',
            image: 'BBBBBB'
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

      it('should delete a Service', () => {
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
