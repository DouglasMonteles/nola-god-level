import { Component, LOCALE_ID, OnInit } from '@angular/core';
import { NgApexchartsModule } from "ng-apexcharts";
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import { ProductService } from '../../../services/product.service';
import { ProductSaleByPeriod } from '../../../models/product-sale-by-period';
import { CurrencyPipe, DatePipe, JsonPipe, registerLocaleData } from '@angular/common';
import { SaleService } from '../../../services/sale.service';
import SaleBasicInfo from '../../../models/sale-basic-info';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexTitleSubtitle,
} from "ng-apexcharts";
import { InputText } from "../../../components/form/input-text/input-text";
import localePt from '@angular/common/locales/pt';
import { MinutePipe } from '../../../pipes/minute-pipe';
import { MatIconModule } from '@angular/material/icon';
import { ContentTitle } from "../../../components/content-title/content-title";
import { MatSelectModule } from '@angular/material/select';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';

registerLocaleData(localePt);

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
    MatInputModule,
    InputText,
    CurrencyPipe,
    MinutePipe,
    MatIconModule,
    ContentTitle,
    MatSelectModule,
    MatDatepickerModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
],
  templateUrl: './default-reports.html',
  styleUrl: './default-reports.scss',
  providers: [
    { provide: LOCALE_ID, useValue: 'pt-BR' },
    provideNativeDateAdapter()
  ]
})
export class DefaultReports implements OnInit {

  public chartOptions!: Partial<ChartOptions>;

  products: ProductSaleByPeriod[] = [];

  sale!: SaleBasicInfo;

  selectedSaleId: number | null = null;

  displayedColumns: string[] = ['productId', 'productName', 'quantityOnSale', 'createdAt', 'saleId'];

  periods: any[] = [
    {value: '06:00:00-12:00:00', viewValue: 'Manhã (6h-12h)'},
    {value: '12:00:00-18:00:00', viewValue: 'Tarde (12h-18h)'},
    {value: '18:00:00-23:59:59', viewValue: 'Noite (18h-00h)'},
    {value: '00:00:00-06:00:00', viewValue: 'Madrugada (00h-06h)'},
  ];

  channels: any[] = [
    {value: 'iFood', viewValue: 'iFood'},
    {value: 'Presencial', viewValue: 'Presencial'},
  ];

  filter: FormGroup;

  constructor(
    private _productService: ProductService,
    private _saleService: SaleService,
    private _formBuilder: FormBuilder,
  ) {
    this.filter = this._formBuilder.group({
      start: [new Date(), [Validators.required]],
      end: [new Date(), [Validators.required]],
      period: ['06:00:00-12:00:00', [Validators.required]],
      channel: ['iFood', [Validators.required]],
    });
  }

  ngOnInit(): void {
    
  }

  formattedCreatedAt(createdAt: string, isOnlyDate: boolean = false): string {
    const date = new Date(createdAt);
    const pad = (n: number) => n.toString().padStart(2, '0');
    
    if (isOnlyDate) {
      return `${pad(date.getDate())}/${pad(date.getMonth() + 1)}/${pad(date.getFullYear())}`;
    }

    return `${pad(date.getUTCHours())}:${pad(date.getUTCMinutes())}:${pad(date.getUTCSeconds())}`;
  }

  loadSadeInfo(saleId: number): void {
    this._saleService.findStoreById(saleId).subscribe({
      next: (data) => {
        this.sale = data;
      }
    });
  }

  searchByFilter(): void {
    if (this.filter.valid) {
      console.log(this.filter.value)
      const {
        start,
        end,
        period,
        channel,
      } = this.filter.value;

      const [startTime, finalTime] = period.split("-");
      const initialDate = this.formatStrDate(start);
      const finalDate = this.formatStrDate(end);

      const startTimestamp = `${initialDate}T${startTime}`;
      const finalTimestamp = `${finalDate}T${finalTime}`;

      this._productService.quantityProductSaleByPeriod(
        channel, startTimestamp, finalTimestamp
      ).subscribe({
          next: (data) => {
            if (data.content.length == 0) {
              return;
            }
            
            const date = this.formattedCreatedAt(data.content[0].createdAt, true);
            this.products = data.content;
            this.chartOptions = {
              series: [
                {
                  name: data.content[0].productName,
                  data: data.content.map(it => it.quantityOnSale),
                },
              ],
              chart: {
                height: 550,
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
                text: `Gráfico 1: Quantidade de produtos vendidos na data ${date} no período da tarde`,
                align: "center",
                style: {
                  fontSize: "18px",
                }
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
                  .map(it => this.formattedCreatedAt(it)),
              },
            };
          }
        });
    }
  }

  formatStrDate(date: string) {
    const d = new Date(date);

    const year = d.getFullYear();
    const month = String(d.getMonth() + 1).padStart(2, '0');
    const day = String(d.getDate()).padStart(2, '0');

    return `${year}-${month}-${day}`;
  }

}
