import { Component, OnInit, Input } from '@angular/core';
import { ProductServiceService } from 'src/app/services/product-service.service';
import { Product } from '../product';
import { AuthServiceService } from 'src/app/auth-service.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

public isAdmin:boolean=false;
  @Input() public type:Product[];
 // @Input() public filter:Product[];
  public del:Product[];
  constructor(private productService:ProductServiceService,private authService:AuthServiceService,private router:Router) { }

  ngOnInit() {
    this.isAdmin = this.authService.isAdmin;
   
     
    
  }
 delete(code:string){
    this.productService.productDelete(code).subscribe( (data)=>{this.ngOnInit()});

  this.router.navigate(['search-box']);
 }

}
