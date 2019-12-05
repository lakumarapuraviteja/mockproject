import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductServiceService } from 'src/app/services/product-service.service';

@Component({
  selector: 'app-product-bill',
  templateUrl: './product-bill.component.html',
  styleUrls: ['./product-bill.component.css']
})
export class ProductBillComponent implements OnInit {
  prodList:Product[]
  filteredlist:Product[]
  searchKey:string
  userList:Product[]
  total:number=0;
  contactNumber:string;

  constructor(private productService:ProductServiceService) { }

  ngOnInit() {
    this.userList=[]
    this.productService.allProducts().subscribe(
      data =>{ this.prodList=data;
        this.filteredlist = data;
        console.log(this.filteredlist)
      });
  }

  newSearch() {
    
    this.filteredlist = this.prodList.filter(data => (data.productName.toLowerCase().indexOf(this.searchKey.toLocaleLowerCase())!=-1)||(data.productCode.toLowerCase().indexOf(this.searchKey.toLocaleLowerCase())!=-1));
   }

   list(product:Product){
    let added: boolean= false;
    console.log(product)
    product.quantity=1;
    this.userList.forEach(element => {
     if(element.productCode.match( product.productCode)){
       added=true;
     }  
    });
if (!added) {
 this.userList.push(product);     
 this.total= this.total + (+product.rate);
}
    
  }
  remove(product:Product) {
    if(product.quantity<=1){
      let index = this.userList.indexOf(product);
       this.userList.splice(index,1);
    }
   if(product.quantity > 0) {
     product.quantity--;
     this.total= this.total - (+product.rate); 
   }

 }

 add(product:Product) {
   product.quantity++;
   this.total= this.total + (+product.rate); 
 }

 onSaveClick(){
 this.userList.forEach(element => {
   this.productService.postBill(this.contactNumber,element.productCode,element.quantity).subscribe(
     data=>{
       console.log(data)
     }
   )
  })
  alert("Billed Successfully");
}




}
