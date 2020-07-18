import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharityDashBoardComponent } from './charity-dash-board.component';

describe('CharityDashBoardComponent', () => {
  let component: CharityDashBoardComponent;
  let fixture: ComponentFixture<CharityDashBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharityDashBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharityDashBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
