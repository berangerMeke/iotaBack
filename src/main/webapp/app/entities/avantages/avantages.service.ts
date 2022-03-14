import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IAvantages } from 'app/shared/model/avantages.model';

type EntityResponseType = HttpResponse<IAvantages>;
type EntityArrayResponseType = HttpResponse<IAvantages[]>;

@Injectable({ providedIn: 'root' })
export class AvantagesService {
  public resourceUrl = SERVER_API_URL + 'api/avantages';

  constructor(protected http: HttpClient) {}

  create(avantages: IAvantages): Observable<EntityResponseType> {
    return this.http.post<IAvantages>(this.resourceUrl, avantages, { observe: 'response' });
  }

  update(avantages: IAvantages): Observable<EntityResponseType> {
    return this.http.put<IAvantages>(this.resourceUrl, avantages, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IAvantages>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IAvantages[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
