import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductSaleByPeriod } from '../models/product-sale-by-period';
import { HttpClient } from '@angular/common/http';
import { Page } from '../models/page';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private client = inject(HttpClient);
  
  public quantityProductSaleByPeriod(): Observable<Page<ProductSaleByPeriod>> {
    return this.client.get<Page<ProductSaleByPeriod>>("http://localhost:8080/products/reports/quantityProductSaleByPeriod", {
      params: {
        page: 0,
        size: 30,
        channelName: "iFood",
        initialDateTime: "2025-06-01T18:00:00",
        finalDateTime: "2025-06-01T23:00:00"
      }
    });
  }

}
