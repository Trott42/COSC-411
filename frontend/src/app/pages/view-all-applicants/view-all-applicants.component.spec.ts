import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllApplicantsComponent } from './view-all-applicants.component';

describe('ViewAllApplicantsComponent', () => {
  let component: ViewAllApplicantsComponent;
  let fixture: ComponentFixture<ViewAllApplicantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewAllApplicantsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewAllApplicantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
