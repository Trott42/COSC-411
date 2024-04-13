import { Component } from '@angular/core';
import { HeaderComponent } from '../../../../../../../IdeaProjects/resume-scanner-frontend/test-ss/src/components/header/header.component';
import { NavbarComponent } from '../../../../../../../IdeaProjects/resume-scanner-frontend/test-ss/src/components/navbar/navbar.component';
import { FooterComponent } from '../../../../../../../IdeaProjects/resume-scanner-frontend/test-ss/src/components/footer/footer.component';
import { JobPostingComponent } from '../../../../../../../IdeaProjects/resume-scanner-frontend/test-ss/src/components/job-posting/job-posting.component';

@Component({
  selector: 'app-candidate-job-list',
  standalone: true,
  imports: [
    HeaderComponent,
    NavbarComponent,
    FooterComponent,
    JobPostingComponent
  ],
  templateUrl: './candidate-job-list.component.html',
  styleUrl: './candidate-job-list.component.scss'
})
export class CandidateJobListComponent {

}
