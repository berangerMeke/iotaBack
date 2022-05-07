import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { JhiLanguageService } from 'ng-jhipster';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiParseLinks, JhiDataUtils } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Location } from '@angular/common';

import {TransfertDataService} from '../../core/services/transfert-data.service';

import { IAccueil } from 'app/shared/model/accueil.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { AccueilService } from './accueil.service';
import { AccueilDeleteDialogComponent } from './accueil-delete-dialog.component';

@Component({
  selector: 'jhi-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit, OnDestroy {
  accueils: IAccueil[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;
  lg: any;

  constructor(
    protected accueilService: AccueilService,
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal,
    public languageService: JhiLanguageService,
    private location: Location,
    public transfertDataService: TransfertDataService,
    protected parseLinks: JhiParseLinks
  ) {
    this.accueils = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.accueilService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IAccueil[]>) => this.paginateAccueils(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.accueils = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.lg = this.languageService.currentLang;
    this.loadAll();
    this.registerChangeInAccueils();
    localStorage.setItem("isNew", "false");
  }


  createIntro(): void {
    localStorage.setItem("isNew", "true");
  }

  back(): void {
    this.location.back()
  }


  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IAccueil): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    return this.dataUtils.openFile(contentType, base64String);
  }

  registerChangeInAccueils(): void {
    this.eventSubscriber = this.eventManager.subscribe('accueilListModification', () => this.reset());
  }

  delete(accueil: IAccueil): void {
    const modalRef = this.modalService.open(AccueilDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.accueil = accueil;
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

  protected paginateAccueils(data: IAccueil[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.accueils.push(data[i]);
      }
    }
  }
}
