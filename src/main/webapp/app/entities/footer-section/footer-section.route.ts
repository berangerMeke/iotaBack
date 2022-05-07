import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IFooterSection, FooterSection } from 'app/shared/model/footer-section.model';
import { FooterSectionService } from './footer-section.service';
import { FooterSectionComponent } from './footer-section.component';
import { FooterSectionDetailComponent } from './footer-section-detail.component';
import { FooterSectionUpdateComponent } from './footer-section-update.component';

@Injectable({ providedIn: 'root' })
export class FooterSectionResolve implements Resolve<IFooterSection> {
  constructor(private service: FooterSectionService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IFooterSection> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((footerSection: HttpResponse<FooterSection>) => {
          if (footerSection.body) {
            return of(footerSection.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new FooterSection());
  }
}

export const footerSectionRoute: Routes = [
  {
    path: '',
    component: FooterSectionComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.footerSection.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: FooterSectionDetailComponent,
    resolve: {
      footerSection: FooterSectionResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.footerSection.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: FooterSectionUpdateComponent,
    resolve: {
      footerSection: FooterSectionResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.footerSection.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: FooterSectionUpdateComponent,
    resolve: {
      footerSection: FooterSectionResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'iotaOrignAdminApp.footerSection.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
