import { BehaviorSubject } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SidebarService {
  visible = false;
  selectedEmail: string = '';
  selectedPhone: string = '';
  selectedAddress: string = '';
  selectedCity: string = '';
  selectedZipCode: string = '';
  selectedEmailIndex: number = -1;

  selectedEmail$ = new BehaviorSubject<string>('');
  selectedPhone$ = new BehaviorSubject<string>('');
  selectedAddress$ = new BehaviorSubject<string>('');
  selectedCity$ = new BehaviorSubject<string>('');
  selectedZipCode$ = new BehaviorSubject<string>('');

  show() {
    this.visible = true;
  }

  show2(email: string, phone: string, address: string, city: string, zipcode: string, index: number) {
    this.visible = true;
    this.selectedEmail = email;
    this.selectedPhone = phone;
    this.selectedAddress = address;
    this.selectedCity = city;
    this.selectedZipCode = zipcode;
    this.selectedEmailIndex = index;
    this.selectedEmail$.next(this.selectedEmail);
    this.selectedPhone$.next(this.selectedPhone);
    this.selectedAddress$.next(this.selectedAddress);
    this.selectedCity$.next(this.selectedCity);
    this.selectedZipCode$.next(this.selectedZipCode);
  }

  hide() {
    this.visible = false;
  }
}
