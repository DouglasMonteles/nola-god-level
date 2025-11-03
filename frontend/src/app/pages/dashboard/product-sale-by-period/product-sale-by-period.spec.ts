import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductSaleByPeriod } from './product-sale-by-period';

describe('ProductSaleByPeriod', () => {
  let component: ProductSaleByPeriod;
  let fixture: ComponentFixture<ProductSaleByPeriod>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductSaleByPeriod]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductSaleByPeriod);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
