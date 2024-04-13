import { Component } from '@angular/core';
import {HeaderComponent1} from "../../components/header/header.component";
import {NavbarComponent1} from "../../components/navbar/navbar.component";
import {FooterComponent1} from "../../components/footer/footer.component";
import {LoginPopupComponent} from "../../components/login-popup/login-popup.component";


@Component({
  selector: 'app-employer-login',
  standalone: true,
  imports: [HeaderComponent1, NavbarComponent1, LoginPopupComponent, FooterComponent1],
  templateUrl: './employer-login.component.html',
  styleUrl: './employer-login.component.scss'
})
export class EmployerLoginComponent1 {

}
