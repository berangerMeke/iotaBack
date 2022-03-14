import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiParseLinks, JhiDataUtils } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {TransfertDataService} from '../../core/services/transfert-data.service';

import { IObjectifs } from 'app/shared/model/objectifs.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { ObjectifsService } from './objectifs.service';
import { ObjectifsDeleteDialogComponent } from './objectifs-delete-dialog.component';

@Component({
  selector: 'jhi-objectifs',
  templateUrl: './objectifs.component.html',
  styleUrls: ['./objectifs.component.scss']
})
export class ObjectifsComponent implements OnInit, OnDestroy {
  objectifs: IObjectifs[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;

  constructor(
    protected objectifsService: ObjectifsService,
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    public transfertDataService: TransfertDataService,
    protected modalService: NgbModal,
    protected parseLinks: JhiParseLinks
  ) {
    this.objectifs = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.objectifsService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IObjectifs[]>) => this.paginateObjectifs(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.objectifs = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInObjectifs();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IObjectifs): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    return this.dataUtils.openFile(contentType, base64String);
  }

  registerChangeInObjectifs(): void {
    this.eventSubscriber = this.eventManager.subscribe('objectifsListModification', () => this.reset());
  }

  delete(objectifs: IObjectifs): void {
    const modalRef = this.modalService.open(ObjectifsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.objectifs = objectifs;
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

  protected paginateObjectifs(data: IObjectifs[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.objectifs.push(data[i]);
      }
    }
  }
}
