import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'accueil',
        loadChildren: () => import('./accueil/accueil.module').then(m => m.IotaOrignAdminAccueilModule)
      },
      {
        path: 'a-propos',
        loadChildren: () => import('./a-propos/a-propos.module').then(m => m.IotaOrignAdminAProposModule)
      },
      {
        path: 'service',
        loadChildren: () => import('./service/service.module').then(m => m.IotaOrignAdminServiceModule)
      },
      {
        path: 'avantages',
        loadChildren: () => import('./avantages/avantages.module').then(m => m.IotaOrignAdminAvantagesModule)
      },
      {
        path: 'objectifs',
        loadChildren: () => import('./objectifs/objectifs.module').then(m => m.IotaOrignAdminObjectifsModule)
      },
      {
        path: 'fa-qs',
        loadChildren: () => import('./fa-qs/fa-qs.module').then(m => m.IotaOrignAdminFAQsModule)
      },
      {
        path: 'equipe',
        loadChildren: () => import('./equipe/equipe.module').then(m => m.IotaOrignAdminEquipeModule)
      },
      {
        path: 'dernieres-nouvelles',
        loadChildren: () => import('./dernieres-nouvelles/dernieres-nouvelles.module').then(m => m.IotaOrignAdminDernieresNouvellesModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class IotaOrignAdminEntityModule {}
