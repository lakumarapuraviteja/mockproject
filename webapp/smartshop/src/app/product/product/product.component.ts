import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../product';
import { ProductServiceService } from 'src/app/services/product-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  list:String[];
  productList: Product[];
 

  constructor(private productService:ProductServiceService,private router:Router) { }

  ngOnInit() {
    this.productService.getAllProductTypes().subscribe(
      data =>{this.list=data; 
      this.list=data
    console.log(this.list)});
  }
  products(type:string){
    this.productService.getProductList(type).subscribe(data => this.productList = data)
    // this.router.navigate(['type']);
    this.productService.setIsSearch(true);
  }
 
}
