import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { SidebarService } from '../../service/sidebar.service';
import { Job } from 'src/app/model/Job';
import { DataService } from 'src/app/service/data.service';
import { FormBuilder, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-job-posting-employee',
  standalone: true,
  imports: [   CommonModule,
    SidebarComponent,FormsModule],
  templateUrl: './job-posting-employee.component.html',
  styleUrl: './job-posting-employee.component.scss'
})
export class JobPostingEmployeeComponent {
  errors="";
  public job: Job[]=[]; 
  constructor(public sidebarService: SidebarService,private formBuilder: FormBuilder,private dataService: DataService,private router: Router) {
    this.sidebarService = sidebarService;
    

  }
  ngOnInit(): void {
    this.dataService.getAllJobs()
    .subscribe(job => this.job = job);

 
}

  gotoApplicants(): void{ 
    this.router.navigateByUrl('/view-applicants');
  }


}
