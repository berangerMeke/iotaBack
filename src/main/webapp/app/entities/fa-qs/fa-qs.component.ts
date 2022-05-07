import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { Location } from '@angular/common';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiEventManager, JhiParseLinks } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {TransfertDataService} from '../../core/services/transfert-data.service';

import { IFAQs } from 'app/shared/model/fa-qs.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { FAQsService } from './fa-qs.service';
import { FAQsDeleteDialogComponent } from './fa-qs-delete-dialog.component';

@Component({
  selector: 'jhi-fa-qs',
  templateUrl: './fa-qs.component.html', 
  styleUrls: ['./fa-qs.component.scss']
})
export class FAQsComponent implements OnInit, OnDestroy {
  fAQs: IFAQs[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;

  lg: any;

  constructor(
    protected fAQsService: FAQsService,
    protected eventManager: JhiEventManager,
    public transfertDataService:TransfertDataService,
    private location: Location,
    public languageService: JhiLanguageService,
    protected modalService: NgbModal,
    protected parseLinks: JhiParseLinks
  ) {
    this.fAQs = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.fAQsService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IFAQs[]>) => this.paginateFAQs(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.fAQs = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.lg = this.languageService.currentLang;
    this.loadAll();
    this.registerChangeInFAQs();
  }


  back(): void {
    this.location.back()
  }

  createfAQs(): void {
    localStorage.setItem("isNewFAQs", "true");
  }



  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IFAQs): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInFAQs(): void {
    this.eventSubscriber = this.eventManager.subscribe('fAQsListModification', () => this.reset());
  }

  delete(fAQs: IFAQs): void {
    const modalRef = this.modalService.open(FAQsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.fAQs = fAQs;
  }

  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected paginateFAQs(data: IFAQs[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.fAQs.push(data[i]);
      }
    }
  }
}
