import { Component } from '@angular/core';
import {HeaderComponent} from "../../app/components/header/header.component";
import {NavbarComponent} from "../../app/components/navbar/navbar.component";
import {FooterComponent} from "../../app/components/footer/footer.component";
import {LoginPopupComponent} from "../../app/components/login-popup/login-popup.component";


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
export class EmployerLoginComponent1 {

}
