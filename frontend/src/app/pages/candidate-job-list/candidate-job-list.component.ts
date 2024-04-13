import { Component } from '@angular/core';
import { HeaderComponent } from '../../app/components/header/header.component';
import { NavbarComponent } from '../../app/components/navbar/navbar.component';
import { FooterComponent } from '../../app/components/footer/footer.component';
import { JobPostingComponent } from '../../app/components/job-posting/job-posting.component';

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
