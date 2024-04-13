import { Component } from '@angular/core';
import {FooterComponent1} from "../../components/footer/footer.component";
import {HeaderComponent1} from "../../components/header/header.component";
import {NavbarComponent1} from "../../components/navbar/navbar.component";
import {AboutBodyComponent1} from "../../components/about-body/about-body.component";

@Component({
  selector: 'app-about-page',
  standalone: true,
  imports: [
    HeaderComponent1,
    NavbarComponent1,
    AboutBodyComponent1,
    FooterComponent1

  ],
  templateUrl: './about-page.component.html',
  styleUrl: './about-page.component.scss'
})
export class AboutPageComponent1 {

}
