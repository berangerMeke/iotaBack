import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IImprint } from 'app/shared/model/imprint.model';

type EntityResponseType = HttpResponse<IImprint>;
type EntityArrayResponseType = HttpResponse<IImprint[]>;

@Injectable({ providedIn: 'root' })
export class ImprintService {
  public resourceUrl = SERVER_API_URL + 'api/imprints';

  constructor(protected http: HttpClient) {}

  create(imprint: IImprint): Observable<EntityResponseType> {
    return this.http.post<IImprint>(this.resourceUrl, imprint, { observe: 'response' });
  }

  update(imprint: IImprint): Observable<EntityResponseType> {
    return this.http.put<IImprint>(this.resourceUrl, imprint, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IImprint>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IImprint[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
