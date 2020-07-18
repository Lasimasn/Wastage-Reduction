import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryBoyDashBoardComponent } from './delivery-boy-dash-board.component';

describe('DeliveryBoyDashBoardComponent', () => {
  let component: DeliveryBoyDashBoardComponent;
  let fixture: ComponentFixture<DeliveryBoyDashBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeliveryBoyDashBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeliveryBoyDashBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
