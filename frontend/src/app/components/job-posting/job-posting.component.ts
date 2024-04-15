import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { SidebarService } from '../../service/sidebar.service';
import { Job } from 'src/app/model/Job';
import { DataService } from 'src/app/service/data.service';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

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
export class JobPostingComponent implements OnInit {
  errors="";
  public job: Job[]=[]; 
  constructor(public sidebarService: SidebarService,private formBuilder: FormBuilder,private dataService: DataService,private router: Router) {
    this.sidebarService = sidebarService;
    

  }
  ngOnInit(): void {
    this.dataService.getAllJobs()
    .subscribe(Job => this.job = Job);
}
@Input() jobTitle!: string;
@Input() location!: string;
@Input() datePosted!: string;
@Input() showButton!: boolean;
@Input() jobDesc!: string;
  }

