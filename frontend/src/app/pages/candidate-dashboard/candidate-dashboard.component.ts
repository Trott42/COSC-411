import { Component } from '@angular/core';
import { JobPostingComponent } from '../../components/job-posting/job-posting.component';
import { JobDashboardComponent } from 'src/app/components/job-dashboard/job-dashboard.component';

@Component({
  selector: 'app-candidate-dashboard',
  standalone: true,
  imports: [JobDashboardComponent],
  templateUrl: './candidate-dashboard.component.html',
  styleUrl: './candidate-dashboard.component.scss'
})
export class CandidateDashboardComponent {

}
