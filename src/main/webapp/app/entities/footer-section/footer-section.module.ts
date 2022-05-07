import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';

import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { FooterSectionComponent } from './footer-section.component';
import { FooterSectionDetailComponent } from './footer-section-detail.component';
import { FooterSectionUpdateComponent } from './footer-section-update.component';
import { FooterSectionDeleteDialogComponent } from './footer-section-delete-dialog.component';
import { footerSectionRoute } from './footer-section.route';

@NgModule({
  imports: [CKEditorModule, IotaOrignAdminSharedModule, RouterModule.forChild(footerSectionRoute)],
  declarations: [FooterSectionComponent, FooterSectionDetailComponent, FooterSectionUpdateComponent, FooterSectionDeleteDialogComponent],
  entryComponents: [FooterSectionDeleteDialogComponent]
})
export class IotaOrignAdminFooterSectionModule {}
