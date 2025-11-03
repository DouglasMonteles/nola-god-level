import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContentTitle } from './content-title';

describe('ContentTitle', () => {
  let component: ContentTitle;
  let fixture: ComponentFixture<ContentTitle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContentTitle]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContentTitle);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
