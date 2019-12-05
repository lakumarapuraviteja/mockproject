import { Product } from './product';

export interface BillHistory{
    billId:number;
    billDate:Date;
    products:Product;
    quantity:number;
}

