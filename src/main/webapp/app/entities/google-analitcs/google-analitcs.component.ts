import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiParseLinks } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Location } from '@angular/common';

import { IGoogleAnalitcs } from 'app/shared/model/google-analitcs.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { GoogleAnalitcsService } from './google-analitcs.service';
import { GoogleAnalitcsDeleteDialogComponent } from './google-analitcs-delete-dialog.component';

@Component({
  selector: 'jhi-google-analitcs',
  templateUrl: './google-analitcs.component.html',
  styleUrls: ['./google-analytics-update.scss']
})
export class GoogleAnalitcsComponent implements OnInit, OnDestroy {
  googleAnalitcs: IGoogleAnalitcs[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;

  constructor(
    protected googleAnalitcsService: GoogleAnalitcsService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal,
    private location: Location,
    protected parseLinks: JhiParseLinks
  ) {
    this.googleAnalitcs = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.googleAnalitcsService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IGoogleAnalitcs[]>) => this.paginateGoogleAnalitcs(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.googleAnalitcs = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInGoogleAnalitcs();
    localStorage.setItem("isNew", "false");
  }

  createGoogleStatID(): void {
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

  trackId(index: number, item: IGoogleAnalitcs): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInGoogleAnalitcs(): void {
    this.eventSubscriber = this.eventManager.subscribe('googleAnalitcsListModification', () => this.reset());
  }

  delete(googleAnalitcs: IGoogleAnalitcs): void {
    const modalRef = this.modalService.open(GoogleAnalitcsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.googleAnalitcs = googleAnalitcs;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected paginateGoogleAnalitcs(data: IGoogleAnalitcs[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.googleAnalitcs.push(data[i]);
      }
    }
  }
}
