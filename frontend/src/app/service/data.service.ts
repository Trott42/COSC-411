import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Job } from '../model/Job';
import { Application } from '../model/Application';
const BASE_URL = ['http://localhost:8080/api']
@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }
  candidateLogin(loginRequest: any): Observable<any> {
    return this.http.post(BASE_URL + "/candidates/authenticate", loginRequest)
  }

  employeeLogin(loginRequest: any): Observable<any> {
    return this.http.post(BASE_URL + "/employees/authenticate", loginRequest)
  }

  signup(signupRequest: any): Observable<any> {
    return this.http.post(BASE_URL + "/candidates/candidate", signupRequest)
  }

  getAllJobs(): Observable<any> {
    return this.http.get(BASE_URL + "/jobs/job");
  }
  createApplication(applicationRequest: any): Observable<any> {
    return this.http.post(BASE_URL + "/applications/apply", applicationRequest)
  }
  getAllApplications(): Observable<any> {
    return this.http.get(BASE_URL + "/applications/apply");
  }
  getCandidatebyId(getOrderRequest: any): Observable<any> {
    const params = {
      candidateId: getOrderRequest.candidateId,
    };
    return this.http.get<Job[]>(BASE_URL + "/candidates/candidate", {params});
  }
  getApplicationByCandidateId(getOrderRequest: any): Observable<any> {
    const params = {
      candidateId: getOrderRequest.candidateId,
    };
    return this.http.get<Application[]>(BASE_URL + "/applications/apply-get", {params});
  }

  decision(getOrderRequest: any): Observable<any> {
    const params = {
      candidateId: getOrderRequest.candidateId,
      applicationStatus:getOrderRequest.applicationStatus,
      employeeId:getOrderRequest.employeeId
    };
    return this.http.get<Application[]>(BASE_URL + "/applications/decision", {params});
  }

  getJobById(getOrderRequest: any): Observable<any> {
    const params = {
      jobId: getOrderRequest.jobId,
    };
    return this.http.get<Job[]>(BASE_URL + "/jobs/job-get", {params});
  }
  private createAuthorizationHeader() {
    const jwtToken = localStorage.getItem('JWT');
    if (jwtToken) {
      return new HttpHeaders().set(
        'Authorization', 'Bearer ' + jwtToken
      )
    } else {
      console.log("JWT token not found in the Local Storage");
    }
    return null;
  }
}
