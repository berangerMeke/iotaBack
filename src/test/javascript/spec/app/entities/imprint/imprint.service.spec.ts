import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ImprintService } from 'app/entities/imprint/imprint.service';
import { IImprint, Imprint } from 'app/shared/model/imprint.model';

describe('Service Tests', () => {
  describe('Imprint Service', () => {
    let injector: TestBed;
    let service: ImprintService;
    let httpMock: HttpTestingController;
    let elemDefault: IImprint;
    let expectedResult: IImprint | IImprint[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ImprintService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new Imprint(0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a Imprint', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new Imprint()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Imprint', () => {
        const returnedFromService = Object.assign(
          {
            titreImprintEn: 'BBBBBB',
            titreImprintFr: 'BBBBBB',
            titreImprintGer: 'BBBBBB',
            titreImprintSw: 'BBBBBB',
            contenuImprintEn: 'BBBBBB',
            contenuImprintGer: 'BBBBBB',
            contenuImprintFr: 'BBBBBB',
            contenuImprintSw: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of Imprint', () => {
        const returnedFromService = Object.assign(
          {
            titreImprintEn: 'BBBBBB',
            titreImprintFr: 'BBBBBB',
            titreImprintGer: 'BBBBBB',
            titreImprintSw: 'BBBBBB',
            contenuImprintEn: 'BBBBBB',
            contenuImprintGer: 'BBBBBB',
            contenuImprintFr: 'BBBBBB',
            contenuImprintSw: 'BBBBBB'
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

      it('should delete a Imprint', () => {
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
