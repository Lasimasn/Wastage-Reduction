import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantLogsComponent } from './restaurant-logs.component';

describe('RestaurantLogsComponent', () => {
  let component: RestaurantLogsComponent;
  let fixture: ComponentFixture<RestaurantLogsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestaurantLogsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantLogsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
