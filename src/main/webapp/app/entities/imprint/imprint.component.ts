import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiParseLinks } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiLanguageService } from 'ng-jhipster';
import { Location } from '@angular/common';
import {TransfertDataService} from '../../core/services/transfert-data.service';

import { IImprint } from 'app/shared/model/imprint.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { ImprintService } from './imprint.service';
import { ImprintDeleteDialogComponent } from './imprint-delete-dialog.component';

@Component({
  selector: 'jhi-imprint',
  templateUrl: './imprint.component.html',
  styleUrls: ['./imprint.scss']
})
export class ImprintComponent implements OnInit, OnDestroy {
  imprints: IImprint[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;

  lg: any;

  constructor(
    protected imprintService: ImprintService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal,
    public languageService: JhiLanguageService,
    public transfertDataService:TransfertDataService,
    private location: Location,
    protected parseLinks: JhiParseLinks
  ) {
    this.imprints = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.imprintService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IImprint[]>) => this.paginateImprints(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.imprints = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.lg = this.languageService.currentLang;
    this.loadAll();
    this.registerChangeInImprints();
  }

  back(): void {
    this.location.back()
  }

  createImprint(): void {
    localStorage.setItem("isNewImprint", "true");
  }

  update(elt: any): void {
    this.transfertDataService.setData(elt);
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IImprint): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInImprints(): void {
    this.eventSubscriber = this.eventManager.subscribe('imprintListModification', () => this.reset());
  }

  delete(imprint: IImprint): void {
    const modalRef = this.modalService.open(ImprintDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.imprint = imprint;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected paginateImprints(data: IImprint[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.imprints.push(data[i]);
      }
    }
  }
}
