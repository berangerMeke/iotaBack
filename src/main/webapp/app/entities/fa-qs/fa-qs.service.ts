import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IFAQs } from 'app/shared/model/fa-qs.model';

type EntityResponseType = HttpResponse<IFAQs>;
type EntityArrayResponseType = HttpResponse<IFAQs[]>;

@Injectable({ providedIn: 'root' })
export class FAQsService {
  public resourceUrl = SERVER_API_URL + 'api/fa-qs';

  constructor(protected http: HttpClient) {}

  create(fAQs: IFAQs): Observable<EntityResponseType> {
    return this.http.post<IFAQs>(this.resourceUrl, fAQs, { observe: 'response' });
  }

  update(fAQs: IFAQs): Observable<EntityResponseType> {
    return this.http.put<IFAQs>(this.resourceUrl, fAQs, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IFAQs>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IFAQs[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
