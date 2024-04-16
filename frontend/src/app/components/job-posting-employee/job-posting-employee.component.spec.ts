import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobPostingEmployeeComponent } from './job-posting-employee.component';

describe('JobPostingEmployeeComponent', () => {
  let component: JobPostingEmployeeComponent;
  let fixture: ComponentFixture<JobPostingEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JobPostingEmployeeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(JobPostingEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
