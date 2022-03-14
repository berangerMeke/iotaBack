import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IObjectifs, Objectifs } from 'app/shared/model/objectifs.model';
import { ObjectifsService } from './objectifs.service';
import { ObjectifsComponent } from './objectifs.component';
import { ObjectifsDetailComponent } from './objectifs-detail.component';
import { ObjectifsUpdateComponent } from './objectifs-update.component';

@Injectable({ providedIn: 'root' })
export class ObjectifsResolve implements Resolve<IObjectifs> {
  constructor(private service: ObjectifsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IObjectifs> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((objectifs: HttpResponse<Objectifs>) => {
          if (objectifs.body) {
            return of(objectifs.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Objectifs());
  }
}

export const objectifsRoute: Routes = [
  {
    path: '',
    component: ObjectifsComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.objectifs.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ObjectifsDetailComponent,
    resolve: {
      objectifs: ObjectifsResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.objectifs.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ObjectifsUpdateComponent,
    resolve: {
      objectifs: ObjectifsResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.objectifs.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ObjectifsUpdateComponent,
    resolve: {
      objectifs: ObjectifsResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.objectifs.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
