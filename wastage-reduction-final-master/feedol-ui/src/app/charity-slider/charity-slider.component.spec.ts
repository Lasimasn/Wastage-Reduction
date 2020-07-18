import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharitySliderComponent } from './charity-slider.component';

describe('CharitySliderComponent', () => {
  let component: CharitySliderComponent;
  let fixture: ComponentFixture<CharitySliderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharitySliderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharitySliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
