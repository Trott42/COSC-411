import { Component } from '@angular/core';
import {HeaderComponent} from "../../components/header/header.component";
import {NavbarComponent} from "../../components/navbar/navbar.component";
import {FooterComponent} from "../../components/footer/footer.component";
import {LoginPopupComponent} from "../../components/login-popup/login-popup.component";

@Component({
  selector: 'app-employer-login',
  standalone: true,
  imports: [
    HeaderComponent, 
    NavbarComponent, 
    LoginPopupComponent, 
    FooterComponent
  ],
  templateUrl: './employer-login.component.html',
  styleUrl: './employer-login.component.scss'
})
export class EmployerLoginComponent {

}
