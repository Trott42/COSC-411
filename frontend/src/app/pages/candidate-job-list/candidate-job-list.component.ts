import { Component } from '@angular/core';
import { HeaderComponent } from '../../components/header/header.component';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FooterComponent } from '../../components/footer/footer.component';
import { JobPostingComponent } from '../../components/job-posting/job-posting.component';
import { jobs } from 'src/app/service/jobs';
import { DataService } from 'src/app/service/data.service';
import { SidebarService } from 'src/app/service/sidebar.service';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Job } from 'src/app/model/Job';

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
  //public jobList = jobs;
  public jobList: Job[]=[]; 
  constructor(public sidebarService: SidebarService,private formBuilder: FormBuilder,private dataService: DataService,private router: Router) {
    this.sidebarService = sidebarService;
    

  }
  ngOnInit(): void {
    this.dataService.getAllJobs()
    .subscribe(jobList => this.jobList = jobList);
}
}
