import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { Location } from '@angular/common';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiEventManager, JhiParseLinks, JhiDataUtils } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {TransfertDataService} from '../../core/services/transfert-data.service';

import { IDernieresNouvelles } from 'app/shared/model/dernieres-nouvelles.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { DernieresNouvellesService } from './dernieres-nouvelles.service';
import { DernieresNouvellesDeleteDialogComponent } from './dernieres-nouvelles-delete-dialog.component';


@Component({
  selector: 'jhi-dernieres-nouvelles',
  templateUrl: './dernieres-nouvelles.component.html',
  styleUrls: ['./dernieres-nouvelles.component.scss']
})
export class DernieresNouvellesComponent implements OnInit, OnDestroy {
  dernieresNouvelles: IDernieresNouvelles[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;

  lg: any;

  constructor(
    protected dernieresNouvellesService: DernieresNouvellesService,
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    private location: Location,
    public languageService: JhiLanguageService,
    public transfertDataService:TransfertDataService,
    protected modalService: NgbModal,
    protected parseLinks: JhiParseLinks
  ) {
    this.dernieresNouvelles = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.dernieresNouvellesService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IDernieresNouvelles[]>) => this.paginateDernieresNouvelles(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.dernieresNouvelles = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.lg = this.languageService.currentLang;
    this.loadAll();
    this.registerChangeInDernieresNouvelles();
  }

  back(): void {
    this.location.back()
  }

  createDernieresnouvelles(): void {
    localStorage.setItem("isNewDernieresNouvelles", "true");
  }


  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }


  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IDernieresNouvelles): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    return this.dataUtils.openFile(contentType, base64String);
  }

  registerChangeInDernieresNouvelles(): void {
    this.eventSubscriber = this.eventManager.subscribe('dernieresNouvellesListModification', () => this.reset());
  }

  delete(dernieresNouvelles: IDernieresNouvelles): void {
    const modalRef = this.modalService.open(DernieresNouvellesDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.dernieresNouvelles = dernieresNouvelles;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected paginateDernieresNouvelles(data: IDernieresNouvelles[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.dernieresNouvelles.push(data[i]);
      }
    }
  }
}