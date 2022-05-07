import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { Location } from '@angular/common';
import { JhiEventManager, JhiParseLinks, JhiDataUtils } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiLanguageService } from 'ng-jhipster';

import { IFooterSection } from 'app/shared/model/footer-section.model';

import {TransfertDataService} from '../../core/services/transfert-data.service';
import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { FooterSectionService } from './footer-section.service';


import { FooterSectionDeleteDialogComponent } from './footer-section-delete-dialog.component';


@Component({
  selector: 'jhi-footer-section',
  templateUrl: './footer-section.component.html',
  styleUrls: ['./footer.scss']
})
export class FooterSectionComponent implements OnInit, OnDestroy {

  footerSections: IFooterSection[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;
  lg: any;


  constructor(
    protected footerSectionService: FooterSectionService,
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal,
    public languageService: JhiLanguageService,
    public transfertDataService:TransfertDataService,
    private location: Location,
    protected parseLinks: JhiParseLinks
  ) {
    this.footerSections = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.footerSectionService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IFooterSection[]>) => this.paginateFooterSections(res.body, res.headers));
 
    }

  reset(): void {
    this.page = 0;
    this.footerSections = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.lg = this.languageService.currentLang;
    this.loadAll();
    this.registerChangeInFooterSections();
  }

  back(): void {
    this.location.back()
  }

  createFooter(): void {
    localStorage.setItem("isNewFooter", "true");
  }

  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IFooterSection): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    return this.dataUtils.openFile(contentType, base64String);
  }

  registerChangeInFooterSections(): void {
    this.eventSubscriber = this.eventManager.subscribe('footerSectionListModification', () => this.reset());
  }

  delete(footerSection: IFooterSection): void {
    const modalRef = this.modalService.open(FooterSectionDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.footerSection = footerSection;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected paginateFooterSections(data: IFooterSection[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.footerSections.push(data[i]);
      }
    }
  }
}
