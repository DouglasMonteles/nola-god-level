export default interface SaleBasicInfo {
  id: number;
  sale1: string;
  sale2: string;
  customerName: string;
  deliveryFee: number;
  deliverySeconds: number;
  discountReason: string;
  increaseReason: string;
  origin: string;
  peopleQuantity: number;
  productionSeconds: number;
  saleStatusDesc: string;
  serviceTaxFee: number;
  totalAmount: number;
  totalAmountItems: number;
  totalDiscount: number;
  totalIncrease: number;
  valuePaid: number;
  createdAt: string;
  channelName: string;
  storeName: string;
  subBrandName: string;
}