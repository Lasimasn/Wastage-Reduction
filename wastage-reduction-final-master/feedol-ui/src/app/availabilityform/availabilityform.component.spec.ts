import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailabilityformComponent } from './availabilityform.component';

describe('AvailabilityformComponent', () => {
  let component: AvailabilityformComponent;
  let fixture: ComponentFixture<AvailabilityformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AvailabilityformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailabilityformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
