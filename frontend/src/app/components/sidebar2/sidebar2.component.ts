import { Component } from '@angular/core';
import { SidebarService } from 'src/app/service/sidebar.service';
import { ViewApplicantsComponent } from '../view-applicants/view-applicants.component';

@Component({
  selector: 'app-sidebar2',
  standalone: true,
  imports: [],
  templateUrl: './sidebar2.component.html',
  styleUrl: './sidebar2.component.scss'
})
export class Sidebar2Component {
  public sidebarService: SidebarService
  constructor(parent: ViewApplicantsComponent) {
    this.sidebarService = parent.sidebarService;
}
}
