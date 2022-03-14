import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IAvantages, Avantages } from 'app/shared/model/avantages.model';
import { AvantagesService } from './avantages.service';
import { AvantagesComponent } from './avantages.component';
import { AvantagesDetailComponent } from './avantages-detail.component';
import { AvantagesUpdateComponent } from './avantages-update.component';

@Injectable({ providedIn: 'root' })
export class AvantagesResolve implements Resolve<IAvantages> {
  constructor(private service: AvantagesService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IAvantages> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((avantages: HttpResponse<Avantages>) => {
          if (avantages.body) {
            return of(avantages.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Avantages());
  }
}

export const avantagesRoute: Routes = [
  {
    path: '',
    component: AvantagesComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.avantages.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: AvantagesDetailComponent,
    resolve: {
      avantages: AvantagesResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.avantages.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: AvantagesUpdateComponent,
    resolve: {
      avantages: AvantagesResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.avantages.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: AvantagesUpdateComponent,
    resolve: {
      avantages: AvantagesResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.avantages.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
