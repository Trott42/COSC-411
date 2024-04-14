import { Component } from '@angular/core';
import { LoginPopupComponent } from 'src/app/components/login-popup/login-popup.component';

@Component({
  selector: 'app-candidate-login',
  standalone: true,
  imports: [LoginPopupComponent],
  templateUrl: './candidate-login.component.html',
  styleUrl: './candidate-login.component.scss'
})
export class CandidateLoginComponent {

}
