import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { PrivacyPolicyService } from 'app/entities/privacy-policy/privacy-policy.service';
import { IPrivacyPolicy, PrivacyPolicy } from 'app/shared/model/privacy-policy.model';

describe('Service Tests', () => {
  describe('PrivacyPolicy Service', () => {
    let injector: TestBed;
    let service: PrivacyPolicyService;
    let httpMock: HttpTestingController;
    let elemDefault: IPrivacyPolicy;
    let expectedResult: IPrivacyPolicy | IPrivacyPolicy[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(PrivacyPolicyService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new PrivacyPolicy(0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a PrivacyPolicy', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new PrivacyPolicy()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a PrivacyPolicy', () => {
        const returnedFromService = Object.assign(
          {
            titrePrivacyPolicyEn: 'BBBBBB',
            titrePrivacyPolicyGer: 'BBBBBB',
            titrePrivacyPolicyFr: 'BBBBBB',
            titrePrivacyPolicySw: 'BBBBBB',
            contenuPrivacyPolicyEn: 'BBBBBB',
            contenuPrivacyPolicyGer: 'BBBBBB',
            contenuPrivacyPolicyFr: 'BBBBBB',
            contenuPrivacyPolicySw: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of PrivacyPolicy', () => {
        const returnedFromService = Object.assign(
          {
            titrePrivacyPolicyEn: 'BBBBBB',
            titrePrivacyPolicyGer: 'BBBBBB',
            titrePrivacyPolicyFr: 'BBBBBB',
            titrePrivacyPolicySw: 'BBBBBB',
            contenuPrivacyPolicyEn: 'BBBBBB',
            contenuPrivacyPolicyGer: 'BBBBBB',
            contenuPrivacyPolicyFr: 'BBBBBB',
            contenuPrivacyPolicySw: 'BBBBBB'
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

      it('should delete a PrivacyPolicy', () => {
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
