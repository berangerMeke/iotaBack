import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IAPropos, APropos } from 'app/shared/model/a-propos.model';
import { AProposService } from './a-propos.service';
import { AProposComponent } from './a-propos.component';
import { AProposDetailComponent } from './a-propos-detail.component';
import { AProposUpdateComponent } from './a-propos-update.component';

@Injectable({ providedIn: 'root' })
export class AProposResolve implements Resolve<IAPropos> {
  constructor(private service: AProposService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IAPropos> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((aPropos: HttpResponse<APropos>) => {
          if (aPropos.body) {
            return of(aPropos.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new APropos());
  }
}

export const aProposRoute: Routes = [
  {
    path: '',
    component: AProposComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.aPropos.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: AProposDetailComponent,
    resolve: {
      aPropos: AProposResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.aPropos.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: AProposUpdateComponent,
    resolve: {
      aPropos: AProposResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.aPropos.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: AProposUpdateComponent,
    resolve: {
      aPropos: AProposResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.aPropos.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
