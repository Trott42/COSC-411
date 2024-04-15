import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { CandidateLoginComponent } from './pages/candidate-login/candidate-login.component';
import { EmployerLoginComponent } from './pages/employer-login/employer-login.component';
import { AboutBodyComponent } from './components/about-body/about-body.component';
import { CandidateJobListComponent } from './pages/candidate-job-list/candidate-job-list.component';
import { CandidateDashboardComponent } from './pages/candidate-dashboard/candidate-dashboard.component';
import { RegisterComponent } from './components/register/register.component';
import { CandidateRegisterComponent } from './pages/candidate-register/candidate-register.component';

const routes: Routes = [
  { path: 'home', component: HomePageComponent },
  { path: 'about', component: AboutBodyComponent },
  { path: 'login', component: CandidateLoginComponent },
  { path: 'employer-login', component: EmployerLoginComponent },
  { path: 'job-list', component: CandidateJobListComponent },
  { path: 'dashboard', component: CandidateDashboardComponent },
  { path: 'register', component: CandidateRegisterComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
