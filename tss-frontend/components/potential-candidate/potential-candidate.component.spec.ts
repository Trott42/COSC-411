import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PotentialCandidateComponent } from './potential-candidate.component';

describe('PotentialCandidateComponent', () => {
  let component: PotentialCandidateComponent;
  let fixture: ComponentFixture<PotentialCandidateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PotentialCandidateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PotentialCandidateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
