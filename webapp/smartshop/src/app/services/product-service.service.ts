import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../product/product';

import { HttpHeaders, HttpClient } from '@angular/common/http';
import { AuthServiceService } from '../auth-service.service';
import { BillHistory } from '../product/bill-history';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  public isSearch:boolean;
setIsSearch(isSearch:boolean){
this.isSearch = isSearch;
}
getIsSearch():boolean{
return this.isSearch;
}



  constructor(private httpClient:HttpClient,private authservice:AuthServiceService) { }
  getAllProductTypes():Observable<string[]>{
    let headers=new HttpHeaders();
 headers=headers.set('Authorization','Bearer '+this.authservice.getToken());
     return this.httpClient.get<string[]>('http://localhost:8087/smartshop-service/search-box',{headers});
}

getProductList(name:string):Observable<Product[]>{
  let headers=new HttpHeaders();
  headers=headers.set('Authorization','Bearer '+this.authservice.getToken());
      return this.httpClient.get<Product[]>('http://localhost:8087/smartshop-service/search-box/'+name,{headers});
 } 
 getAllProductList(list:string):Observable<Product>{
  let headers=new HttpHeaders();
  headers=headers.set('Authorization','Bearer '+this.authservice.getToken());
      return this.httpClient.get<Product>('http://localhost:8087/smartshop-service/search-box/product-edit/'+list,{headers});
 } 
 modifyProduct(product:Product):Observable<Product>
{
  console.log('In service modify',product);
  let headers=new HttpHeaders();
 headers=headers.set('Authorization','Bearer '+this.authservice.getToken());
     return this.httpClient.put<Product>('http://localhost:8087/smartshop-service/search-box/',product,{headers}); 
    }

    addProducts(pro:Product):Observable<null>
    {
      
      let headers=new HttpHeaders();
     headers=headers.set('Authorization','Bearer '+this.authservice.getToken());
         return this.httpClient.post<null>('http://localhost:8087/smartshop-service/search-box/add',pro,{headers}); 
        }

        productDelete(list:string):Observable<null>{
          let headers=new HttpHeaders();
          headers=headers.set('Authorization','Bearer '+this.authservice.getToken());
              return this.httpClient.delete<null>('http://localhost:8087/smartshop-service/search-box/delete/'+list,{headers});
         } 
         allProducts():Observable<Product[]>
         {
          let headers=new HttpHeaders();
          headers=headers.set('Authorization','Bearer '+this.authservice.getToken());
              return this.httpClient.get<Product[]>('http://localhost:8087/smartshop-service/search-box/all',{headers});
         }
         
         postBill(contact:string,code:string,quantity:number):Observable<BillHistory[]>
         {
          let headers=new HttpHeaders();
          headers=headers.set('Authorization','Bearer '+this.authservice.getToken());
              return this.httpClient.post<BillHistory[]>('http://localhost:8087/smartshop-service/search-box/bill/'+contact+'/'+code+'/'+quantity,{headers});
         }

         getBillHistory(name:string):Observable<BillHistory[]>
         {
         let headers=new HttpHeaders();
         headers=headers.set('Authorization','Bearer '+this.authservice.getToken());
         return this.httpClient.get<BillHistory[]>('http://localhost:8087/smartshop-service/search-box/bill/'+name,{headers}); 
         }




}
