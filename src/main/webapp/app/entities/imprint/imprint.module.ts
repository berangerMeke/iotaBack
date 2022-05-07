import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';

import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { ImprintComponent } from './imprint.component';
import { ImprintDetailComponent } from './imprint-detail.component';
import { ImprintUpdateComponent } from './imprint-update.component';
import { ImprintDeleteDialogComponent } from './imprint-delete-dialog.component';
import { imprintRoute } from './imprint.route';

@NgModule({
  imports: [CKEditorModule, IotaOrignAdminSharedModule, RouterModule.forChild(imprintRoute)],
  declarations: [ImprintComponent, ImprintDetailComponent, ImprintUpdateComponent, ImprintDeleteDialogComponent],
  entryComponents: [ImprintDeleteDialogComponent]
})
export class IotaOrignAdminImprintModule {}
