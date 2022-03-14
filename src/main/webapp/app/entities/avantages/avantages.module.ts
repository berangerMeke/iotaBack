import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { AvantagesComponent } from './avantages.component';
import { AvantagesDetailComponent } from './avantages-detail.component';
import { AvantagesUpdateComponent } from './avantages-update.component';
import { AvantagesDeleteDialogComponent } from './avantages-delete-dialog.component';
import { avantagesRoute } from './avantages.route';

@NgModule({
  imports: [IotaOrignAdminSharedModule, RouterModule.forChild(avantagesRoute)],
  declarations: [AvantagesComponent, AvantagesDetailComponent, AvantagesUpdateComponent, AvantagesDeleteDialogComponent],
  entryComponents: [AvantagesDeleteDialogComponent]
})
export class IotaOrignAdminAvantagesModule {}
