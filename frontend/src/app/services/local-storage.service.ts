import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {
  
  public save(key: string, value: any): void {
    const valueStr = JSON.stringify(value);
    localStorage.setItem(key, valueStr);
  }

  public findByKey(key: string): any | null {
    const value = localStorage.getItem(key);

    if (value != null) {
      return JSON.parse(value);
    }

    return null;
  }

}
