import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiParseLinks } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Location } from '@angular/common';
import { JhiLanguageService } from 'ng-jhipster';

import { IPrivacyPolicy } from 'app/shared/model/privacy-policy.model';
import {TransfertDataService} from '../../core/services/transfert-data.service';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { PrivacyPolicyService } from './privacy-policy.service';
import { PrivacyPolicyDeleteDialogComponent } from './privacy-policy-delete-dialog.component';

@Component({
  selector: 'jhi-privacy-policy',
  templateUrl: './privacy-policy.component.html',
  styleUrls: ['./privacy-policy.scss']
})
export class PrivacyPolicyComponent implements OnInit, OnDestroy {
  privacyPolicies: IPrivacyPolicy[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;
  lg: any;

  constructor(
    protected privacyPolicyService: PrivacyPolicyService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal,
    public languageService: JhiLanguageService,
    public transfertDataService:TransfertDataService,
    private location: Location,
    protected parseLinks: JhiParseLinks
  ) {
    this.privacyPolicies = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.privacyPolicyService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IPrivacyPolicy[]>) => this.paginatePrivacyPolicies(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.privacyPolicies = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.lg = this.languageService.currentLang;
    this.loadAll();
    this.registerChangeInPrivacyPolicies();
  }

  back(): void {
    this.location.back()
  }

  createPrivacyPolicy(): void {
    localStorage.setItem("isNewPrivacyPolicy", "true");
  }

  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IPrivacyPolicy): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInPrivacyPolicies(): void {
    this.eventSubscriber = this.eventManager.subscribe('privacyPolicyListModification', () => this.reset());
  }

  delete(privacyPolicy: IPrivacyPolicy): void {
    const modalRef = this.modalService.open(PrivacyPolicyDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.privacyPolicy = privacyPolicy;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected paginatePrivacyPolicies(data: IPrivacyPolicy[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.privacyPolicies.push(data[i]);
      }
    }
  }
}
