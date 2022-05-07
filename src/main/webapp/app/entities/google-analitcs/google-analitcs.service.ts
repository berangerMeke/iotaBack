import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IGoogleAnalitcs } from 'app/shared/model/google-analitcs.model';

type EntityResponseType = HttpResponse<IGoogleAnalitcs>;
type EntityArrayResponseType = HttpResponse<IGoogleAnalitcs[]>;

@Injectable({ providedIn: 'root' })
export class GoogleAnalitcsService {
  public resourceUrl = SERVER_API_URL + 'api/google-analitcs';

  constructor(protected http: HttpClient) {}

  create(googleAnalitcs: IGoogleAnalitcs): Observable<EntityResponseType> {
    return this.http.post<IGoogleAnalitcs>(this.resourceUrl, googleAnalitcs, { observe: 'response' });
  }

  update(googleAnalitcs: IGoogleAnalitcs): Observable<EntityResponseType> {
    return this.http.put<IGoogleAnalitcs>(this.resourceUrl, googleAnalitcs, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IGoogleAnalitcs>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IGoogleAnalitcs[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
