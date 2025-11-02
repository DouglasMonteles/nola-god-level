import { Component, OnInit } from '@angular/core';
import { NgApexchartsModule } from "ng-apexcharts";

import {
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexTitleSubtitle
} from "ng-apexcharts";
import { ProductService } from '../../../services/product.service';
import { map } from 'rxjs';
import { JsonPipe, NgClass } from '@angular/common';
import { ProductSaleByPeriod } from '../../../models/product-sale-by-period';

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  dataLabels: ApexDataLabels;
  grid: ApexGrid;
  stroke: ApexStroke;
  title: ApexTitleSubtitle;
};

@Component({
  selector: 'app-default-reports',
  imports: [
    NgApexchartsModule,
    JsonPipe,
    NgClass
],
  templateUrl: './default-reports.html',
  styleUrl: './default-reports.scss',
})
export class DefaultReports implements OnInit {

  public chartOptions!: Partial<ChartOptions>;

  products: ProductSaleByPeriod[] = [
    
  ];

  constructor(
    private _productService: ProductService
  ) {

  }

  ngOnInit(): void {
    this._productService.quantityProductSaleByPeriod()
      .pipe(map(response => {
        const content = response.content.map(it => {
          return {
            ...it,
            createdAt: this.formattedCreatedAt(it.createdAt)
          };
        })
        response.content = content;
        return response;
      }))
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
              categories: data.content.map(it => it.createdAt),
            },
          };
        }
      });
  }

  formattedCreatedAt(createdAt: string): string {
    const date = new Date(createdAt);
    return `${date.getUTCHours().toString().padStart(2, "0")}:${date.getUTCMinutes().toString().padStart(2, "0")}:${date.getUTCSeconds().toString().padStart(2, "0")}`;
  }

}
