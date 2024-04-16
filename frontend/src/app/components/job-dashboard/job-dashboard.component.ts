import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Application } from 'src/app/model/Application';
import { Job } from 'src/app/model/Job';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-job-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './job-dashboard.component.html',
  styleUrl: './job-dashboard.component.scss'
})
export class JobDashboardComponent implements OnInit {
  errors="";
  public job: Job=new Job; 
  public app:Application=new Application;
  jobId: string = "";
  jobTitle:string="";
  applicationStatus: string = "";
  submittedDate:string="";
  constructor(private formBuilder: FormBuilder,private dataService: DataService,private router: Router) {

  }
  ngOnInit(): void {
      console.log("Test");
      const id= localStorage.getItem('CANDIDATEID');
      if (id !== null) {
        this.app.candidateId = parseInt(id);
      }
      this.dataService.getApplicationByCandidateId(this.app).subscribe(
        (response) => {
          
          this.jobId = response.jobId;
          this.applicationStatus=response.applicationStatus;
          this.submittedDate=response.submittedDate;

          console.log(" Jobs",response.jobId);
          this.job.jobId=response.jobId;
          this.dataService.getJobById(this.job).subscribe(
            (response2) => {
              this.jobTitle=response2.jobTitle;

            },
            (error) => {
              console.error(error);
              this.errors = "Cannot find Order";
            }
          );
          

        },
        (error) => {
          console.error(error);
          this.errors = "Cannot find Order";
        }
      );
    }
}

