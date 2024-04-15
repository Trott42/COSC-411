import { Component } from '@angular/core';
import { RegisterComponent } from 'src/app/components/register/register.component';

@Component({
  selector: 'app-candidate-register',
  standalone: true,
  imports: [RegisterComponent],
  templateUrl: './candidate-register.component.html',
  styleUrl: './candidate-register.component.scss'
})
export class CandidateRegisterComponent {

}
