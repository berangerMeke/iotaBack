import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { AProposComponent } from './a-propos.component';
import { AProposDetailComponent } from './a-propos-detail.component';
import { AProposUpdateComponent } from './a-propos-update.component';
import { AProposDeleteDialogComponent } from './a-propos-delete-dialog.component';
import { aProposRoute } from './a-propos.route';

@NgModule({
  imports: [IotaOrignAdminSharedModule, RouterModule.forChild(aProposRoute)],
  declarations: [AProposComponent, AProposDetailComponent, AProposUpdateComponent, AProposDeleteDialogComponent],
  entryComponents: [AProposDeleteDialogComponent]
})
export class IotaOrignAdminAProposModule {}
