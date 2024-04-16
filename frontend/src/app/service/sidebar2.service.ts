import { BehaviorSubject } from 'rxjs';
import { Injectable } from '@angular/core';
export class SidebarService2 {
  visible = false;
  selectedEmail: string = '';
  selectedEmailIndex: number = -1;
  selectedEmail$ = new BehaviorSubject<string>('');
  show(email: string,index: number) {
    this.visible = true;
    this.selectedEmail = email;
    this.selectedEmailIndex = index;
    this.selectedEmail$.next(this.selectedEmail);
  }

  hide() {
    this.visible = false;
  }

  
}