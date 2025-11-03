import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'minute'
})
export class MinutePipe implements PipeTransform {

  private readonly SEC_MINUTE = 60;

  transform(seconds: number, ...args: unknown[]): string {
    const minute = Math.floor(seconds / this.SEC_MINUTE);
    const second = seconds % this.SEC_MINUTE;
    return `${minute}m ${second}s`;
  }

}
