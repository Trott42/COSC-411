import { Component } from '@angular/core';
import {FooterComponent} from "../../components/footer/footer.component";
import {HeaderComponent} from "../../components/header/header.component";
import {NavbarComponent} from "../../components/navbar/navbar.component";
import {AboutBodyComponent} from "../../components/about-body/about-body.component";

@Component({
  selector: 'app-about-page',
  standalone: true,
  imports: [
    HeaderComponent,
    NavbarComponent,
    AboutBodyComponent,
    FooterComponent
  ],
  templateUrl: './about-page.component.html',
  styleUrl: './about-page.component.scss'
})
export class AboutPageComponent1 {

}
