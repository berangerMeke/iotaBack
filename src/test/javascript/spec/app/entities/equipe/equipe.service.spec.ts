import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { EquipeService } from 'app/entities/equipe/equipe.service';
import { IEquipe, Equipe } from 'app/shared/model/equipe.model';

describe('Service Tests', () => {
  describe('Equipe Service', () => {
    let injector: TestBed;
    let service: EquipeService;
    let httpMock: HttpTestingController;
    let elemDefault: IEquipe;
    let expectedResult: IEquipe | IEquipe[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(EquipeService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new Equipe(
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

      it('should create a Equipe', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new Equipe()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Equipe', () => {
        const returnedFromService = Object.assign(
          {
            titreFr: 'BBBBBB',
            titreEn: 'BBBBBB',
            titreGer: 'BBBBBB',
            titreSw: 'BBBBBB',
            souTitreFr: 'BBBBBB',
            souTitreEn: 'BBBBBB',
            souTitreGer: 'BBBBBB',
            souTitreSw: 'BBBBBB',
            nom1: 'BBBBBB',
            nom2: 'BBBBBB',
            nom3: 'BBBBBB',
            nom4: 'BBBBBB',
            nom5: 'BBBBBB',
            nom6: 'BBBBBB',
            nom7: 'BBBBBB',
            nom8: 'BBBBBB',
            prenom1: 'BBBBBB',
            prenom2: 'BBBBBB',
            prenom3: 'BBBBBB',
            prenom4: 'BBBBBB',
            prenom5: 'BBBBBB',
            prenom6: 'BBBBBB',
            prenom7: 'BBBBBB',
            prenom8: 'BBBBBB',
            qualite1: 'BBBBBB',
            qualite2: 'BBBBBB',
            qualite3: 'BBBBBB',
            qualite4: 'BBBBBB',
            qualite5: 'BBBBBB',
            qualite6: 'BBBBBB',
            qualite7: 'BBBBBB',
            qualite8: 'BBBBBB',
            image1: 'BBBBBB',
            image2: 'BBBBBB',
            image3: 'BBBBBB',
            image4: 'BBBBBB',
            image5: 'BBBBBB',
            image6: 'BBBBBB',
            image7: 'BBBBBB',
            image8: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of Equipe', () => {
        const returnedFromService = Object.assign(
          {
            titreFr: 'BBBBBB',
            titreEn: 'BBBBBB',
            titreGer: 'BBBBBB',
            titreSw: 'BBBBBB',
            souTitreFr: 'BBBBBB',
            souTitreEn: 'BBBBBB',
            souTitreGer: 'BBBBBB',
            souTitreSw: 'BBBBBB',
            nom1: 'BBBBBB',
            nom2: 'BBBBBB',
            nom3: 'BBBBBB',
            nom4: 'BBBBBB',
            nom5: 'BBBBBB',
            nom6: 'BBBBBB',
            nom7: 'BBBBBB',
            nom8: 'BBBBBB',
            prenom1: 'BBBBBB',
            prenom2: 'BBBBBB',
            prenom3: 'BBBBBB',
            prenom4: 'BBBBBB',
            prenom5: 'BBBBBB',
            prenom6: 'BBBBBB',
            prenom7: 'BBBBBB',
            prenom8: 'BBBBBB',
            qualite1: 'BBBBBB',
            qualite2: 'BBBBBB',
            qualite3: 'BBBBBB',
            qualite4: 'BBBBBB',
            qualite5: 'BBBBBB',
            qualite6: 'BBBBBB',
            qualite7: 'BBBBBB',
            qualite8: 'BBBBBB',
            image1: 'BBBBBB',
            image2: 'BBBBBB',
            image3: 'BBBBBB',
            image4: 'BBBBBB',
            image5: 'BBBBBB',
            image6: 'BBBBBB',
            image7: 'BBBBBB',
            image8: 'BBBBBB'
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

      it('should delete a Equipe', () => {
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
