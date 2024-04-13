import { Component, NgZone} from '@angular/core';
import { FooterComponent } from './components/footer/footer.component';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent  {
  title = 'Test Software Solutions';
  user = '';
  constructor(private ngZone: NgZone) {}
  ngOnInit() {
    this.ngZone.run(() => {
    });
    
  }
}
