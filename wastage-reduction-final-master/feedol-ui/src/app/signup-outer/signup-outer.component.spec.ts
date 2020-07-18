import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupOuterComponent } from './signup-outer.component';

describe('SignupOuterComponent', () => {
  let component: SignupOuterComponent;
  let fixture: ComponentFixture<SignupOuterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignupOuterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupOuterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
