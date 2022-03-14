import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IAccueil, Accueil } from 'app/shared/model/accueil.model';
import { AccueilService } from './accueil.service';
import { AccueilComponent } from './accueil.component';
import { AccueilDetailComponent } from './accueil-detail.component';
import { AccueilUpdateComponent } from './accueil-update.component';

@Injectable({ providedIn: 'root' })
export class AccueilResolve implements Resolve<IAccueil> {
  constructor(private service: AccueilService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IAccueil> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((accueil: HttpResponse<Accueil>) => {
          if (accueil.body) {
            return of(accueil.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Accueil());
  }
}

export const accueilRoute: Routes = [
  {
    path: '',
    component: AccueilComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.accueil.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: AccueilDetailComponent,
    resolve: {
      accueil: AccueilResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.accueil.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: AccueilUpdateComponent,
    resolve: {
      accueil: AccueilResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.accueil.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: AccueilUpdateComponent,
    resolve: {
      accueil: AccueilResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.accueil.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
