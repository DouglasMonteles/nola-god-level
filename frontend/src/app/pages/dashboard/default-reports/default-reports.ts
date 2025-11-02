import { Component, OnInit } from '@angular/core';
import { NgApexchartsModule } from "ng-apexcharts";
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';

import {
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexTitleSubtitle,
} from "ng-apexcharts";
import { ProductService } from '../../../services/product.service';
import { ProductSaleByPeriod } from '../../../models/product-sale-by-period';
import { DatePipe, JsonPipe } from '@angular/common';
import { SaleService } from '../../../services/sale.service';
import SaleBasicInfo from '../../../models/sale-basic-info';
import { MatFormFieldControl, MatFormFieldModule } from '@angular/material/form-field';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  dataLabels: ApexDataLabels;
  grid: ApexGrid;
  stroke: ApexStroke;
  title: ApexTitleSubtitle;
};

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'app-default-reports',
  imports: [
    NgApexchartsModule,
    MatTableModule,
    DatePipe,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule
  ],
  templateUrl: './default-reports.html',
  styleUrl: './default-reports.scss',
})
export class DefaultReports implements OnInit {

  public chartOptions!: Partial<ChartOptions>;

  products: ProductSaleByPeriod[] = [];

  sale!: SaleBasicInfo;

  displayedColumns: string[] = ['productId', 'productName', 'quantityOnSale', 'productQuantityTotalSales', 'createdAt', 'saleId'];

  constructor(
    private _productService: ProductService,
    private _saleService: SaleService,
    private _formBuilder: FormBuilder,
  ) {
  }

  ngOnInit(): void {
    this._productService.quantityProductSaleByPeriod()
      .subscribe({
        next: (data) => {
          console.log(data.content.map(it => it.quantityOnSale).reduce((prev, curr) => prev + curr, 0))
          this.products = data.content;
          this.chartOptions = {
            series: [
              {
                name: "X-Tudo",
                data: data.content.map(it => it.quantityOnSale),
              }
            ],
            chart: {
              height: 350,
              // foreColor: "white",
              type: "line",
              zoom: {
                enabled: false,
              }
            },
            dataLabels: {
              enabled: false
            },
            stroke: {
              curve: "straight"
            },
            title: {
              text: "Quantidade de produtos vendidos na data 01/01/2024 no período da tarde",
              align: "center"
            },
            grid: {
              row: {
                colors: ["#f3f3f3", "transparent"],
                opacity: 0.5
              }
            },
            xaxis: {
              categories: data.content
                .map(it => it.createdAt)
                .map(this.formattedCreatedAt),
            },
          };
        }
      });

    this._saleService.findStoreById(1).subscribe({
      next: (data) => {
        this.sale = data;
      }
    });
  }

  formattedCreatedAt(createdAt: string): string {
    const date = new Date(createdAt);
    return `${date.getUTCHours().toString().padStart(2, "0")}:${date.getUTCMinutes().toString().padStart(2, "0")}:${date.getUTCSeconds().toString().padStart(2, "0")}`;
  }

}
