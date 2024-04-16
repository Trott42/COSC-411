import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';    
@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink,CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit{ 
  constructor() { }
  name:string="";
  ngOnInit(): void {
    // Call the method to check local storage on component initialization
    this.checkLocalStorage();
  }

  // Method to check if candidateId exists in local storage
  checkLocalStorage(): boolean {
    const candidateId = localStorage.getItem('CANDIDATEID');
    const names=localStorage.getItem('EMAIL');
    if (candidateId&&names) {
      // CandidateId exists, perform actions accordingly
      console.log('CandidateId exists in local storage');
      console.log(names)
      this.name=names;
      return true;
      // You can perform additional actions here, such as showing specific buttons, redirecting, etc.
    } else {
      // CandidateId doesn't exist, perform actions accordingly
      console.log('CandidateId does not exist in local storage');
      return false;
      // You can perform additional actions here, such as showing login buttons, redirecting to login page, etc.
    }
  }

  // Method to handle logout button click event
  logout(): void {
    // Implement your logout logic here
    console.log('Logout clicked');
    // For example, you can clear the local storage and redirect to the login page
    localStorage.removeItem('CANDIDATEID');
    localStorage.removeItem('JWT')
    localStorage.removeItem('EMAIL')
    // Redirect to the login page
    // this.router.navigate(['/login']); // Make sure to import Router and inject it in the constructor
  }
  }
