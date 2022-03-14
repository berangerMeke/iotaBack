import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { DernieresNouvellesComponent } from './dernieres-nouvelles.component';
import { DernieresNouvellesDetailComponent } from './dernieres-nouvelles-detail.component';
import { DernieresNouvellesUpdateComponent } from './dernieres-nouvelles-update.component';
import { DernieresNouvellesDeleteDialogComponent } from './dernieres-nouvelles-delete-dialog.component';
import { dernieresNouvellesRoute } from './dernieres-nouvelles.route';

@NgModule({
  imports: [IotaOrignAdminSharedModule, RouterModule.forChild(dernieresNouvellesRoute)],
  declarations: [
    DernieresNouvellesComponent,
    DernieresNouvellesDetailComponent,
    DernieresNouvellesUpdateComponent,
    DernieresNouvellesDeleteDialogComponent
  ],
  entryComponents: [DernieresNouvellesDeleteDialogComponent]
})
export class IotaOrignAdminDernieresNouvellesModule {}
