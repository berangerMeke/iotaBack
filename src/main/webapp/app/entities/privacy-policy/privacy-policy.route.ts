import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IPrivacyPolicy, PrivacyPolicy } from 'app/shared/model/privacy-policy.model';
import { PrivacyPolicyService } from './privacy-policy.service';
import { PrivacyPolicyComponent } from './privacy-policy.component';
import { PrivacyPolicyDetailComponent } from './privacy-policy-detail.component';
import { PrivacyPolicyUpdateComponent } from './privacy-policy-update.component';

@Injectable({ providedIn: 'root' })
export class PrivacyPolicyResolve implements Resolve<IPrivacyPolicy> {
  constructor(private service: PrivacyPolicyService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IPrivacyPolicy> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((privacyPolicy: HttpResponse<PrivacyPolicy>) => {
          if (privacyPolicy.body) {
            return of(privacyPolicy.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new PrivacyPolicy());
  }
}

export const privacyPolicyRoute: Routes = [
  {
    path: '',
    component: PrivacyPolicyComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.privacyPolicy.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: PrivacyPolicyDetailComponent,
    resolve: {
      privacyPolicy: PrivacyPolicyResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.privacyPolicy.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: PrivacyPolicyUpdateComponent,
    resolve: {
      privacyPolicy: PrivacyPolicyResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.privacyPolicy.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: PrivacyPolicyUpdateComponent,
    resolve: {
      privacyPolicy: PrivacyPolicyResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.privacyPolicy.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
