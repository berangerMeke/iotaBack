import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IAccueil } from 'app/shared/model/accueil.model';

type EntityResponseType = HttpResponse<IAccueil>;
type EntityArrayResponseType = HttpResponse<IAccueil[]>;

@Injectable({ providedIn: 'root' })
export class AccueilService {
  public resourceUrl = SERVER_API_URL + 'api/accueils';

  constructor(protected http: HttpClient) {}

  create(accueil: IAccueil): Observable<EntityResponseType> {
    return this.http.post<IAccueil>(this.resourceUrl, accueil, { observe: 'response' });
  }

  update(accueil: IAccueil): Observable<EntityResponseType> {
    return this.http.put<IAccueil>(this.resourceUrl, accueil, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IAccueil>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IAccueil[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
