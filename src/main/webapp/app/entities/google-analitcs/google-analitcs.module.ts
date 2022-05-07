import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { GoogleAnalitcsComponent } from './google-analitcs.component';
import { GoogleAnalitcsDetailComponent } from './google-analitcs-detail.component';
import { GoogleAnalitcsUpdateComponent } from './google-analitcs-update.component';
import { GoogleAnalitcsDeleteDialogComponent } from './google-analitcs-delete-dialog.component';
import { googleAnalitcsRoute } from './google-analitcs.route';

@NgModule({
  imports: [IotaOrignAdminSharedModule, RouterModule.forChild(googleAnalitcsRoute)],
  declarations: [
    GoogleAnalitcsComponent,
    GoogleAnalitcsDetailComponent,
    GoogleAnalitcsUpdateComponent,
    GoogleAnalitcsDeleteDialogComponent
  ],
  entryComponents: [GoogleAnalitcsDeleteDialogComponent]
})
export class IotaOrignAdminGoogleAnalitcsModule {}
