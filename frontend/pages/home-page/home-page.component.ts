import { Component } from '@angular/core';
import {HeaderComponent1} from "../../components/header/header.component";
import {NavbarComponent1} from "../../components/navbar/navbar.component";

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [HeaderComponent1, NavbarComponent1, ],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.scss'
})
export class HomePageComponent {

}
