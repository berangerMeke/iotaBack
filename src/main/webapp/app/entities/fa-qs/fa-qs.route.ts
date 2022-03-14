import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IFAQs, FAQs } from 'app/shared/model/fa-qs.model';
import { FAQsService } from './fa-qs.service';
import { FAQsComponent } from './fa-qs.component';
import { FAQsDetailComponent } from './fa-qs-detail.component';
import { FAQsUpdateComponent } from './fa-qs-update.component';

@Injectable({ providedIn: 'root' })
export class FAQsResolve implements Resolve<IFAQs> {
  constructor(private service: FAQsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IFAQs> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((fAQs: HttpResponse<FAQs>) => {
          if (fAQs.body) {
            return of(fAQs.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new FAQs());
  }
}

export const fAQsRoute: Routes = [
  {
    path: '',
    component: FAQsComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.fAQs.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: FAQsDetailComponent,
    resolve: {
      fAQs: FAQsResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.fAQs.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: FAQsUpdateComponent,
    resolve: {
      fAQs: FAQsResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.fAQs.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: FAQsUpdateComponent,
    resolve: {
      fAQs: FAQsResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.fAQs.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
