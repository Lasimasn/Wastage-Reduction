import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantSliderComponent } from './restaurant-slider.component';

describe('RestaurantSliderComponent', () => {
  let component: RestaurantSliderComponent;
  let fixture: ComponentFixture<RestaurantSliderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestaurantSliderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantSliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
