import { Component } from '@angular/core';
import { JobPostingComponent } from '../../components/job-posting/job-posting.component';

@Component({
  selector: 'app-candidate-dashboard',
  standalone: true,
  imports: [JobPostingComponent],
  templateUrl: './candidate-dashboard.component.html',
  styleUrl: './candidate-dashboard.component.scss'
})
export class CandidateDashboardComponent {

}
