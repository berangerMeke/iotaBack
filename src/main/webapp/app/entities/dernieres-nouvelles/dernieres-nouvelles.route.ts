import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IDernieresNouvelles, DernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';
import { DernieresNouvellesService } from './dernieres-nouvelles.service';
import { DernieresNouvellesComponent } from './dernieres-nouvelles.component';
import { DernieresNouvellesDetailComponent } from './dernieres-nouvelles-detail.component';
import { DernieresNouvellesUpdateComponent } from './dernieres-nouvelles-update.component';

@Injectable({ providedIn: 'root' })
export class DernieresNouvellesResolve implements Resolve<IDernieresNouvelles> {
  constructor(private service: DernieresNouvellesService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IDernieresNouvelles> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((dernieresNouvelles: HttpResponse<DernieresNouvelles>) => {
          if (dernieresNouvelles.body) {
            return of(dernieresNouvelles.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new DernieresNouvelles());
  }
}

export const dernieresNouvellesRoute: Routes = [
  {
    path: '',
    component: DernieresNouvellesComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.dernieresNouvelles.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: DernieresNouvellesDetailComponent,
    resolve: {
      dernieresNouvelles: DernieresNouvellesResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.dernieresNouvelles.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: DernieresNouvellesUpdateComponent,
    resolve: {
      dernieresNouvelles: DernieresNouvellesResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.dernieresNouvelles.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: DernieresNouvellesUpdateComponent,
    resolve: {
      dernieresNouvelles: DernieresNouvellesResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.dernieresNouvelles.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
