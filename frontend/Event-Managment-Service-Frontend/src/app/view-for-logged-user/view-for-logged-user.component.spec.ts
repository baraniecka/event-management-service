import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewForLoggedUserComponent } from './view-for-logged-user.component';

describe('ViewForLoggedUserComponent', () => {
  let component: ViewForLoggedUserComponent;
  let fixture: ComponentFixture<ViewForLoggedUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewForLoggedUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewForLoggedUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
