import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { User } from 'app/core/user/user.model';

@Component({
  selector: 'jhi-user-mgmt-detail',
  templateUrl: './user-management-detail.component.html',
  styleUrls: ['./user-management.scss']
})
export class UserManagementDetailComponent implements OnInit {
  user: User | null = null;

  constructor(private route: ActivatedRoute, private location: Location, ) {}

  ngOnInit(): void {
    this.route.data.subscribe(({ user }) => (this.user = user));
  }

  back(): void {
    this.location.back()
  }

}
