import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FooterSectionService } from 'app/entities/footer-section/footer-section.service';
import { IFooterSection, FooterSection } from 'app/shared/model/footer-section.model';

describe('Service Tests', () => {
  describe('FooterSection Service', () => {
    let injector: TestBed;
    let service: FooterSectionService;
    let httpMock: HttpTestingController;
    let elemDefault: IFooterSection;
    let expectedResult: IFooterSection | IFooterSection[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(FooterSectionService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new FooterSection(
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

      it('should create a FooterSection', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new FooterSection()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a FooterSection', () => {
        const returnedFromService = Object.assign(
          {
            titreEn: 'BBBBBB',
            titreGer: 'BBBBBB',
            titreFr: 'BBBBBB',
            titreSw: 'BBBBBB',
            sousTitreEn: 'BBBBBB',
            sousTitreGer: 'BBBBBB',
            sousTitreFr: 'BBBBBB',
            sousTitreSw: 'BBBBBB',
            logo: 'BBBBBB',
            texteBouton: 'BBBBBB',
            twitterlink: 'BBBBBB',
            discordLink: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of FooterSection', () => {
        const returnedFromService = Object.assign(
          {
            titreEn: 'BBBBBB',
            titreGer: 'BBBBBB',
            titreFr: 'BBBBBB',
            titreSw: 'BBBBBB',
            sousTitreEn: 'BBBBBB',
            sousTitreGer: 'BBBBBB',
            sousTitreFr: 'BBBBBB',
            sousTitreSw: 'BBBBBB',
            logo: 'BBBBBB',
            texteBouton: 'BBBBBB',
            twitterlink: 'BBBBBB',
            discordLink: 'BBBBBB'
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

      it('should delete a FooterSection', () => {
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
