import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import SaleBasicInfo from '../models/sale-basic-info';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SaleService {

  client = inject(HttpClient);
  
  public findStoreById(storeId: number): Observable<SaleBasicInfo> {
    return this.client.get<SaleBasicInfo>(`http://localhost:8080/sales/${storeId}`);
  }

}
