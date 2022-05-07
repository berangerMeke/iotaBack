import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';

import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { FAQsComponent } from './fa-qs.component';
import { FAQsDetailComponent } from './fa-qs-detail.component';
import { FAQsUpdateComponent } from './fa-qs-update.component';
import { FAQsDeleteDialogComponent } from './fa-qs-delete-dialog.component';
import { fAQsRoute } from './fa-qs.route';

@NgModule({
  imports: [CKEditorModule , IotaOrignAdminSharedModule, RouterModule.forChild(fAQsRoute)],
  declarations: [FAQsComponent, FAQsDetailComponent, FAQsUpdateComponent, FAQsDeleteDialogComponent],
  entryComponents: [FAQsDeleteDialogComponent]
})
export class IotaOrignAdminFAQsModule {}
