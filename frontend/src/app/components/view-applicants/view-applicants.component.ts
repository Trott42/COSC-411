import { Component } from '@angular/core';
import { FormBuilder, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Application } from 'src/app/model/Application';
import { DataService } from 'src/app/service/data.service';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-view-applicants',
  standalone: true,
  imports: [   CommonModule,
   FormsModule],
  templateUrl: './view-applicants.component.html',
  styleUrl: './view-applicants.component.scss'
})
export class ViewApplicantsComponent {
  errors="";
  public application: Application[]=[]; 
  constructor(private formBuilder: FormBuilder,private dataService: DataService,private router: Router) {
    

  }
  ngOnInit(): void {
    this.dataService.getAllApplications()
    .subscribe(application => this.application = application);
}}
