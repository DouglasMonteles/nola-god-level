import { Component, Input, input, OnInit } from '@angular/core';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-simple-table',
  imports: [
    MatTableModule,
  ],
  templateUrl: './simple-table.html',
  styleUrl: './simple-table.scss',
})
export class SimpleTable implements OnInit {

  @Input()
  dataSource: any[] = [];

  @Input()
  columns: string[][] = [];

  @Input()
  displayedColumns: string[] = [];

  ngOnInit(): void {
    this.displayedColumns = this.columns.map(it => it[0]);
  }

}
