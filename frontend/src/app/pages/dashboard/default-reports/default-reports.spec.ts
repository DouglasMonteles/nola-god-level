import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DefaultReports } from './default-reports';

describe('DefaultReports', () => {
  let component: DefaultReports;
  let fixture: ComponentFixture<DefaultReports>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DefaultReports]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DefaultReports);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
