import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { AccueilService } from 'app/entities/accueil/accueil.service';
import { IAccueil, Accueil } from 'app/shared/model/accueil.model';

describe('Service Tests', () => {
  describe('Accueil Service', () => {
    let injector: TestBed;
    let service: AccueilService;
    let httpMock: HttpTestingController;
    let elemDefault: IAccueil;
    let expectedResult: IAccueil | IAccueil[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(AccueilService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new Accueil(
        0,
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

      it('should create a Accueil', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new Accueil()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Accueil', () => {
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

      it('should return a list of Accueil', () => {
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

      it('should delete a Accueil', () => {
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
