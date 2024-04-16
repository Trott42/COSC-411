import { Component } from '@angular/core';
import { JobPostingComponent } from '../job-posting/job-posting.component';
import { SidebarService } from '../../service/sidebar.service';
import { ViewApplicantsComponent } from '../view-applicants/view-applicants.component';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss'
})
export class SidebarComponent {
  public sidebarService: SidebarService
  constructor(parent: JobPostingComponent) {
    this.sidebarService = parent.sidebarService;
   
  }
}
