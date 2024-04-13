import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component'; 
//import {NgxMaskModule} from 'ngx-mask';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './components/footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
   

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    //NgxMaskModule.forRoot(),
    FormsModule,
    ReactiveFormsModule ,
    HttpClientModule,
    FooterComponent 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
