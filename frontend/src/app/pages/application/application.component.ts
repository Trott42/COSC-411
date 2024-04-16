import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-application',
  standalone: true,
  imports: [],
  templateUrl: './application.component.html',
  styleUrl: './application.component.scss'
})
export class ApplicationComponent implements OnInit {
  resume_data: any;
  years_worked: any;
  ngOnInit(): void {
    fetch("http://localhost:5000/ml/scan-results")
    .then(response => {
      if (!response.ok) {
        console.error("FAIL: HTTP Error: " + response.status);
      }
      console.log(response);
      return response.json();
    })
    .then(data => {
      console.log(data)
      if (data.resume && data.score) {
        console.log(data.resume);
        console.log(data.score);

        this.resume_data = data
        this.years_worked = data.resume.experience.end_date - data.resume.experience.start_date
      }
    })
    .catch((error) => {
      console.error("FAIL: fetch returned invalid response: " + error);
    });
  }
}
