import { Component } from '@angular/core';
import { HeaderComponent } from '../../components/header/header.component';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { FooterComponent } from '../../components/footer/footer.component';
import { jobs } from 'src/app/service/jobs';
import { DataService } from 'src/app/service/data.service';
import { SidebarService } from 'src/app/service/sidebar.service';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Job } from 'src/app/model/Job';
import { JobPostingEmployeeComponent } from 'src/app/components/job-posting-employee/job-posting-employee.component';

@Component({
  selector: 'app-employee-dashboard',
  standalone: true,
  imports: [ HeaderComponent,
    NavbarComponent,
    FooterComponent,JobPostingEmployeeComponent],
  templateUrl: './employee-dashboard.component.html',
  styleUrl: './employee-dashboard.component.scss'
})
export class EmployeeDashboardComponent {
  public jobList: Job[]=[]; 
  constructor(public sidebarService: SidebarService,private formBuilder: FormBuilder,private dataService: DataService,private router: Router) {
    this.sidebarService = sidebarService;
    

  }
  ngOnInit(): void {
    this.dataService.getAllJobs()
    .subscribe(jobList => this.jobList = jobList);
}
}
