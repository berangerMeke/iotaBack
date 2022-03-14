import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IAPropos } from 'app/shared/model/a-propos.model';

type EntityResponseType = HttpResponse<IAPropos>;
type EntityArrayResponseType = HttpResponse<IAPropos[]>;

@Injectable({ providedIn: 'root' })
export class AProposService {
  public resourceUrl = SERVER_API_URL + 'api/a-propos';

  constructor(protected http: HttpClient) {}

  create(aPropos: IAPropos): Observable<EntityResponseType> {
    return this.http.post<IAPropos>(this.resourceUrl, aPropos, { observe: 'response' });
  }

  update(aPropos: IAPropos): Observable<EntityResponseType> {
    return this.http.put<IAPropos>(this.resourceUrl, aPropos, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IAPropos>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IAPropos[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
