import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Job } from '../model/Job';
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

  getOrder(getOrderRequest: any): Observable<any> {
    const params = {
      email: getOrderRequest.email,
      orderNumber: getOrderRequest.orderNumber
    };
    return this.http.get<Job[]>(BASE_URL + "get-order", {params});
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
