import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IObjectifs } from 'app/shared/model/objectifs.model';

type EntityResponseType = HttpResponse<IObjectifs>;
type EntityArrayResponseType = HttpResponse<IObjectifs[]>;

@Injectable({ providedIn: 'root' })
export class ObjectifsService {
  public resourceUrl = SERVER_API_URL + 'api/objectifs';

  constructor(protected http: HttpClient) {}

  create(objectifs: IObjectifs): Observable<EntityResponseType> {
    return this.http.post<IObjectifs>(this.resourceUrl, objectifs, { observe: 'response' });
  }

  update(objectifs: IObjectifs): Observable<EntityResponseType> {
    return this.http.put<IObjectifs>(this.resourceUrl, objectifs, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IObjectifs>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IObjectifs[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
