import { Component } from '@angular/core';
import {HeaderComponent} from "../../components/header/header.component";
import {NavbarComponent} from "../../components/navbar/navbar.component";

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [
    HeaderComponent, 
    NavbarComponent
  ],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.scss'
})
export class HomePageComponent {

}
