import { Component, Input } from '@angular/core';
import { FormBuilder, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Application } from 'src/app/model/Application';
import { DataService } from 'src/app/service/data.service';
import { CommonModule } from '@angular/common';
import { Candidate } from 'src/app/model/Candidate';
import { SidebarService } from 'src/app/service/sidebar.service';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { Sidebar2Component } from '../sidebar2/sidebar2.component';
@Component({
  selector: 'app-view-applicants',
  standalone: true,
  imports: [   CommonModule,
   FormsModule,Sidebar2Component],
  templateUrl: './view-applicants.component.html',
  styleUrl: './view-applicants.component.scss'
})
export class ViewApplicantsComponent {
  errors="";
  public application: Application[]=[]; 
  public candidate: Candidate= new Candidate;
  public selectedEmail: string = ''; 
  public selectedPhone: string = ''; 
  public selectedAddress: string = ''; 
  public selectedCity: string = ''; 
  public selectedZipcode: string = ''; 
  public selectedCandidateId: number = 0; 
  fname: string[] = [];
  lname: string[] = [];
  email: string[] = [];
  candidateId: number[] = [];
  phone: string[] = [];
  address: string[] = [];
  city: string[] = [];
  zipcode: string[] = [];
  score: string[]=["55.52","36.17"];
  constructor(public sidebarService: SidebarService,private formBuilder: FormBuilder,private dataService: DataService,private router: Router) {
    

  }
  showCandidateEmail(candidateId:number,email: string,phone:string,address:string, city:string ,zipcode:string, index: number) {
    // Show the sidebar and pass the email and index
    this.sidebarService.show2(candidateId,email,phone,address,city,zipcode, index);
  }
  reject():void{
    this.dataService.decision(this.candidate).subscribe(
      (response) => {


      });
  }
  ngOnInit(): void {
    this.dataService.getAllApplications()
      .subscribe(
        applications => {
          this.application = applications;
          for (let i = 0; i < this.application.length; i++) {
            console.log("Test");
            console.log(this.application[i].candidateId);
            this.candidate.candidateId = this.application[i].candidateId;
            this.dataService.getCandidatebyId(this.candidate).subscribe(
              (response) => {
                this.fname[i] = response.fname;
                this.lname[i] = response.lname;
                this.email[i]=response.email;
                this.phone[i]=response.phone;
                this.selectedEmail = response.email;
                this.address[i]=response.address;
                this.selectedAddress=response.address
                this.city[i]=response.city;
                this.selectedCity = response.city;
                this.zipcode[i]=response.zipcode;
                this.selectedZipcode = response.zipCode;
                this.candidateId[i]=response.candidateId;
                this.selectedCandidateId=this.application[i].candidateId;
              },
              (error) => {
                console.error(error);
                this.errors = "Cannot find Order";
              }
            );
          }
        },
        error => {
          console.error(error);
        }
      );
  }
  @Input() showButton!: boolean;
}
