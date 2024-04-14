import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { SidebarService } from '../sidebar/sidebar.service';

@Component({
  selector: 'app-job-posting',
  standalone: true,
  imports: [ 
    CommonModule,
    SidebarComponent
  ],
  templateUrl: './job-posting.component.html',
  styleUrl: './job-posting.component.scss'
})
export class JobPostingComponent {
  constructor(public sidebarService: SidebarService) {
    this.sidebarService = sidebarService;
  }
  @Input() jobTitle!: string;
  @Input() location!: string;
  @Input() datePosted!: string;
}
