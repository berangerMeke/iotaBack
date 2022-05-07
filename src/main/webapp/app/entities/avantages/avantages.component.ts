import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { Location } from '@angular/common';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiEventManager, JhiParseLinks, JhiDataUtils } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {TransfertDataService} from '../../core/services/transfert-data.service';

import { IAvantages } from 'app/shared/model/avantages.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { AvantagesService } from './avantages.service';
import { AvantagesDeleteDialogComponent } from './avantages-delete-dialog.component';

@Component({
  selector: 'jhi-avantages',
  templateUrl: './avantages.component.html',
  styleUrls: ['./avantages.component.scss']
})
export class AvantagesComponent implements OnInit, OnDestroy {
  avantages: IAvantages[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;

  lg: any;
  

  constructor(
    protected avantagesService: AvantagesService,
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal,
    public languageService: JhiLanguageService,
    private location: Location,
    public transfertDataService: TransfertDataService,
    protected parseLinks: JhiParseLinks
  ) {
    this.avantages = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.avantagesService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IAvantages[]>) => this.paginateAvantages(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.avantages = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.lg = this.languageService.currentLang;
    this.loadAll();
    this.registerChangeInAvantages();
  }


  back(): void {
    this.location.back()
  }

  createAvantages(): void {
    localStorage.setItem("isNewAvantages", "true");
  }


  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IAvantages): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    return this.dataUtils.openFile(contentType, base64String);
  }

  registerChangeInAvantages(): void {
    this.eventSubscriber = this.eventManager.subscribe('avantagesListModification', () => this.reset());
  }

  delete(avantages: IAvantages): void {
    const modalRef = this.modalService.open(AvantagesDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.avantages = avantages;
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

  protected paginateAvantages(data: IAvantages[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.avantages.push(data[i]);
      }
    }
  }
}
