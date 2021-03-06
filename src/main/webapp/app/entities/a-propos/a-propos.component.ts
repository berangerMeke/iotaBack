import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiEventManager, JhiParseLinks, JhiDataUtils } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {TransfertDataService} from '../../core/services/transfert-data.service';
import { Location } from '@angular/common';

import { IAPropos } from 'app/shared/model/a-propos.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { AProposService } from './a-propos.service';
import { AProposDeleteDialogComponent } from './a-propos-delete-dialog.component';

@Component({
  selector: 'jhi-a-propos',
  templateUrl: './a-propos.component.html',
  styleUrls: ['./a-propos.component.scss']
  
})
export class AProposComponent implements OnInit, OnDestroy {
  aPropos: IAPropos[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;

  lg: any;

  constructor(
    protected aProposService: AProposService,
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    private location: Location,
    public languageService: JhiLanguageService,
    public transfertDataService: TransfertDataService,
    protected modalService: NgbModal,
    protected parseLinks: JhiParseLinks
  ) {
    this.aPropos = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.aProposService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IAPropos[]>) => this.paginateAPropos(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.aPropos = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.lg = this.languageService.currentLang;
    this.loadAll();
    this.registerChangeInAPropos();
   // localStorage.setItem('aPropos', JSON.stringify(this.aPropos));
  }

  back(): void {
    this.location.back()
  }

  createApropos(): void {
    localStorage.setItem("isNewApropos", "true");
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IAPropos): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    return this.dataUtils.openFile(contentType, base64String);
  }

  registerChangeInAPropos(): void {
    this.eventSubscriber = this.eventManager.subscribe('aProposListModification', () => this.reset());
  }

  delete(aPropos: IAPropos): void {
    const modalRef = this.modalService.open(AProposDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.aPropos = aPropos;
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

  protected paginateAPropos(data: IAPropos[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.aPropos.push(data[i]);
      }
    }
  }
}
