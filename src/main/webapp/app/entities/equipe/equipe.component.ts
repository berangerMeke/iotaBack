import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiParseLinks, JhiDataUtils } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {TransfertDataService} from '../../core/services/transfert-data.service';

import { IEquipe } from 'app/shared/model/equipe.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { EquipeService } from './equipe.service';
import { EquipeDeleteDialogComponent } from './equipe-delete-dialog.component';

@Component({
  selector: 'jhi-equipe',
  templateUrl: './equipe.component.html',
  styleUrls: ['./equipe.component.scss']
})
export class EquipeComponent implements OnInit, OnDestroy {
  equipes: IEquipe[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;

  constructor(
    protected equipeService: EquipeService,
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    public transfertDataService:TransfertDataService,
    protected modalService: NgbModal,
    protected parseLinks: JhiParseLinks
  ) {
    this.equipes = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.equipeService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IEquipe[]>) => this.paginateEquipes(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.equipes = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInEquipes();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IEquipe): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    return this.dataUtils.openFile(contentType, base64String);
  }

  registerChangeInEquipes(): void {
    this.eventSubscriber = this.eventManager.subscribe('equipeListModification', () => this.reset());
  }

  delete(equipe: IEquipe): void {
    const modalRef = this.modalService.open(EquipeDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.equipe = equipe;
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

  protected paginateEquipes(data: IEquipe[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.equipes.push(data[i]);
      }
    }
  }
}
