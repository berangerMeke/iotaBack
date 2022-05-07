import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';

import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { PrivacyPolicyComponent } from './privacy-policy.component';
import { PrivacyPolicyDetailComponent } from './privacy-policy-detail.component';
import { PrivacyPolicyUpdateComponent } from './privacy-policy-update.component';
import { PrivacyPolicyDeleteDialogComponent } from './privacy-policy-delete-dialog.component';
import { privacyPolicyRoute } from './privacy-policy.route';

@NgModule({
  imports: [CKEditorModule, IotaOrignAdminSharedModule, RouterModule.forChild(privacyPolicyRoute)],
  declarations: [PrivacyPolicyComponent, PrivacyPolicyDetailComponent, PrivacyPolicyUpdateComponent, PrivacyPolicyDeleteDialogComponent],
  entryComponents: [PrivacyPolicyDeleteDialogComponent]
})
export class IotaOrignAdminPrivacyPolicyModule {}
