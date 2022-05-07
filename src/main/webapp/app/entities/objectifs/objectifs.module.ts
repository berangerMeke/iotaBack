import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';

import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { ObjectifsComponent } from './objectifs.component';
import { ObjectifsDetailComponent } from './objectifs-detail.component';
import { ObjectifsUpdateComponent } from './objectifs-update.component';
import { ObjectifsDeleteDialogComponent } from './objectifs-delete-dialog.component';
import { objectifsRoute } from './objectifs.route';

@NgModule({
  imports: [CKEditorModule, IotaOrignAdminSharedModule, RouterModule.forChild(objectifsRoute)],
  declarations: [ObjectifsComponent, ObjectifsDetailComponent, ObjectifsUpdateComponent, ObjectifsDeleteDialogComponent],
  entryComponents: [ObjectifsDeleteDialogComponent]
})
export class IotaOrignAdminObjectifsModule {}
