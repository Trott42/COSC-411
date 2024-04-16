import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { FooterComponent } from 'src/app/components/footer/footer.component';
import { HeaderComponent } from 'src/app/components/header/header.component';
import { NavbarComponent } from 'src/app/components/navbar/navbar.component';
import { ViewApplicantsComponent } from 'src/app/components/view-applicants/view-applicants.component';
import { Application } from 'src/app/model/Application';
import { DataService } from 'src/app/service/data.service';
import { SidebarService } from 'src/app/service/sidebar.service';

@Component({
  selector: 'app-view-all-applicants',
  standalone: true,
  imports: [HeaderComponent,
    NavbarComponent,
    FooterComponent,ViewApplicantsComponent],
  templateUrl: './view-all-applicants.component.html',
  styleUrl: './view-all-applicants.component.scss'
})
export class ViewAllApplicantsComponent {
  public application: Application[]=[]; 
  constructor(private formBuilder: FormBuilder,private dataService: DataService,private router: Router) {
    

  }
  ngOnInit(): void {
    this.dataService.getAllApplications()
    .subscribe(application => this.application = application);
}
}
