import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';

import './vendor';
import { IotaOrignAdminSharedModule } from 'app/shared/shared.module';
import { IotaOrignAdminCoreModule } from 'app/core/core.module';
import { IotaOrignAdminAppRoutingModule } from './app-routing.module';
import { IotaOrignAdminHomeModule } from './home/home.module';
import { IotaOrignAdminEntityModule } from './entities/entity.module';

// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ActiveMenuDirective } from './layouts/navbar/active-menu.directive';
import { ErrorComponent } from './layouts/error/error.component';
import { PanelComponent } from './app/panel/panel.component';

@NgModule({
  imports: [
    BrowserModule,
    IotaOrignAdminSharedModule,
    IotaOrignAdminCoreModule,
    IotaOrignAdminHomeModule,
    CKEditorModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    IotaOrignAdminEntityModule,
    IotaOrignAdminAppRoutingModule
  ],
  declarations: [
    MainComponent, 
    NavbarComponent, 
    ErrorComponent, 
    PageRibbonComponent, 
    ActiveMenuDirective, 
    FooterComponent, 
    PanelComponent
  ],
  bootstrap: [MainComponent]
})
export class IotaOrignAdminAppModule {}
