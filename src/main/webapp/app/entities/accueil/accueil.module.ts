import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { AccueilComponent } from './accueil.component';
import { AccueilDetailComponent } from './accueil-detail.component';
import { AccueilUpdateComponent } from './accueil-update.component';
import { AccueilDeleteDialogComponent } from './accueil-delete-dialog.component';
import { accueilRoute } from './accueil.route';

@NgModule({
  imports: [IotaOrignAdminSharedModule, RouterModule.forChild(accueilRoute)],
  declarations: [AccueilComponent, AccueilDetailComponent, AccueilUpdateComponent, AccueilDeleteDialogComponent],
  entryComponents: [AccueilDeleteDialogComponent]
})
export class IotaOrignAdminAccueilModule {}
