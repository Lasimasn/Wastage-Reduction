import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileEditableComponent } from './profile-editable.component';

describe('ProfileEditableComponent', () => {
  let component: ProfileEditableComponent;
  let fixture: ComponentFixture<ProfileEditableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileEditableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileEditableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
