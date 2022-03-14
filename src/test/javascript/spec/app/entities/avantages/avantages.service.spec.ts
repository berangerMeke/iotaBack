import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { AvantagesService } from 'app/entities/avantages/avantages.service';
import { IAvantages, Avantages } from 'app/shared/model/avantages.model';

describe('Service Tests', () => {
  describe('Avantages Service', () => {
    let injector: TestBed;
    let service: AvantagesService;
    let httpMock: HttpTestingController;
    let elemDefault: IAvantages;
    let expectedResult: IAvantages | IAvantages[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(AvantagesService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new Avantages(
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

      it('should create a Avantages', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new Avantages()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Avantages', () => {
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
            textParagraphe1FR: 'BBBBBB',
            textParagraphe1En: 'BBBBBB',
            textParagraphe1Ger: 'BBBBBB',
            textParagraphe1Sw: 'BBBBBB',
            textParagraphe2Fr: 'BBBBBB',
            textParagraphe2En: 'BBBBBB',
            textParagraphe2Ger: 'BBBBBB',
            textParagraphe2Sw: 'BBBBBB',
            textParagraphe3FR: 'BBBBBB',
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
            textParagraphe6Fr: 'BBBBBB',
            textParagraphe6En: 'BBBBBB',
            textParagraphe6Ger: 'BBBBBB',
            textParagraphe6Sw: 'BBBBBB',
            textParagraphe7Fr: 'BBBBBB',
            textParagraphe7En: 'BBBBBB',
            textParagraphe7Ger: 'BBBBBB',
            textParagraphe7Sw: 'BBBBBB',
            textParagraphe8Fr: 'BBBBBB',
            textParagraphe8En: 'BBBBBB',
            textParagraphe8Ger: 'BBBBBB',
            textParagraphe8Sw: 'BBBBBB',
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

      it('should return a list of Avantages', () => {
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
            textParagraphe1FR: 'BBBBBB',
            textParagraphe1En: 'BBBBBB',
            textParagraphe1Ger: 'BBBBBB',
            textParagraphe1Sw: 'BBBBBB',
            textParagraphe2Fr: 'BBBBBB',
            textParagraphe2En: 'BBBBBB',
            textParagraphe2Ger: 'BBBBBB',
            textParagraphe2Sw: 'BBBBBB',
            textParagraphe3FR: 'BBBBBB',
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
            textParagraphe6Fr: 'BBBBBB',
            textParagraphe6En: 'BBBBBB',
            textParagraphe6Ger: 'BBBBBB',
            textParagraphe6Sw: 'BBBBBB',
            textParagraphe7Fr: 'BBBBBB',
            textParagraphe7En: 'BBBBBB',
            textParagraphe7Ger: 'BBBBBB',
            textParagraphe7Sw: 'BBBBBB',
            textParagraphe8Fr: 'BBBBBB',
            textParagraphe8En: 'BBBBBB',
            textParagraphe8Ger: 'BBBBBB',
            textParagraphe8Sw: 'BBBBBB',
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

      it('should delete a Avantages', () => {
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
