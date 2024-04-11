import { Component } from '@angular/core';
import { HeaderComponent } from '../../components/header/header.component';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FooterComponent } from '../../components/footer/footer.component';
import { JobPostingComponent } from '../../components/job-posting/job-posting.component';

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
