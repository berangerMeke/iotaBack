import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IGoogleAnalitcs, GoogleAnalitcs } from 'app/shared/model/google-analitcs.model';
import { GoogleAnalitcsService } from './google-analitcs.service';
import { GoogleAnalitcsComponent } from './google-analitcs.component';
import { GoogleAnalitcsDetailComponent } from './google-analitcs-detail.component';
import { GoogleAnalitcsUpdateComponent } from './google-analitcs-update.component';

@Injectable({ providedIn: 'root' })
export class GoogleAnalitcsResolve implements Resolve<IGoogleAnalitcs> {
  constructor(private service: GoogleAnalitcsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IGoogleAnalitcs> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((googleAnalitcs: HttpResponse<GoogleAnalitcs>) => {
          if (googleAnalitcs.body) {
            return of(googleAnalitcs.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new GoogleAnalitcs());
  }
}

export const googleAnalitcsRoute: Routes = [
  {
    path: '',
    component: GoogleAnalitcsComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.googleAnalitcs.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: GoogleAnalitcsDetailComponent,
    resolve: {
      googleAnalitcs: GoogleAnalitcsResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.googleAnalitcs.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: GoogleAnalitcsUpdateComponent,
    resolve: {
      googleAnalitcs: GoogleAnalitcsResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.googleAnalitcs.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: GoogleAnalitcsUpdateComponent,
    resolve: {
      googleAnalitcs: GoogleAnalitcsResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.googleAnalitcs.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
