import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IDernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';

type EntityResponseType = HttpResponse<IDernieresNouvelles>;
type EntityArrayResponseType = HttpResponse<IDernieresNouvelles[]>;

@Injectable({ providedIn: 'root' })
export class DernieresNouvellesService {
  public resourceUrl = SERVER_API_URL + 'api/dernieres-nouvelles';

  constructor(protected http: HttpClient) {}

  create(dernieresNouvelles: IDernieresNouvelles): Observable<EntityResponseType> {
    return this.http.post<IDernieresNouvelles>(this.resourceUrl, dernieresNouvelles, { observe: 'response' });
  }

  update(dernieresNouvelles: IDernieresNouvelles): Observable<EntityResponseType> {
    return this.http.put<IDernieresNouvelles>(this.resourceUrl, dernieresNouvelles, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IDernieresNouvelles>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IDernieresNouvelles[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
