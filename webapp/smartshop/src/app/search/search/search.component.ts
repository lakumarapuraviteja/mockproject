import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from 'src/app/services/product-service.service';
import { Product } from 'src/app/product/product';
import { AuthServiceService } from 'src/app/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchKey:string;
  productList: string[];
  filteredList:string[];
  prodList: Product[];
  _filteredlist: Product[];
  isAdmin:boolean;
 
 

 
  constructor(private productservice:ProductServiceService,private authService:AuthServiceService,private router:Router) { }

  ngOnInit() {
     this.isAdmin = this.authService.isAdmin
     this.productservice.setIsSearch(false);
    // this.productservice.getAllProductTypes().subscribe(
    //   data =>{this.productList=data; 
    //   this.filteredList=data
    // console.log(this.filteredList)});

    this.productservice.allProducts().subscribe(
      data =>{ this.prodList=data;
        this._filteredlist = data;
        console.log(this._filteredlist)     
      });
      this.router.navigate(['/search-box']);
    
  }

  search(){
     this._filteredlist=this.prodList.filter(x=>x.productName.toLowerCase().indexOf(this.searchKey.toLowerCase())!=-1);
    //this._filteredlist = this.prodList.filter(data => (data.productName.toLowerCase().indexOf(this.searchKey.toLocaleLowerCase())!=-1));
  
  }
  delete(code:string){
    this.productservice.productDelete(code).subscribe( (data)=>{this.ngOnInit()});

   //this.router.navigate(['search-box']);
   
 }

}
