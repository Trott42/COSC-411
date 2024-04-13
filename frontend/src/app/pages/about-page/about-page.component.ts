import { Component } from '@angular/core';
import {FooterComponent} from "../../app/components/footer/footer.component";
import {HeaderComponent} from "../../app/components/header/header.component";
import {NavbarComponent} from "../../app/components/navbar/navbar.component";
import {AboutBodyComponent} from "../../app/components/about-body/about-body.component";

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
