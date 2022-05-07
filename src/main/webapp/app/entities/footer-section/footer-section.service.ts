import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IFooterSection } from 'app/shared/model/footer-section.model';

type EntityResponseType = HttpResponse<IFooterSection>;
type EntityArrayResponseType = HttpResponse<IFooterSection[]>;

@Injectable({ providedIn: 'root' })
export class FooterSectionService {
  public resourceUrl = SERVER_API_URL + 'api/footer-sections';

  constructor(protected http: HttpClient) {}

  create(footerSection: IFooterSection): Observable<EntityResponseType> {
    return this.http.post<IFooterSection>(this.resourceUrl, footerSection, { observe: 'response' });
  }

  update(footerSection: IFooterSection): Observable<EntityResponseType> {
    return this.http.put<IFooterSection>(this.resourceUrl, footerSection, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IFooterSection>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IFooterSection[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
