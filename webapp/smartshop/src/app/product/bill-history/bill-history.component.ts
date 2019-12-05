import { Component, OnInit } from '@angular/core';
import { BillHistory } from '../bill-history';
import { ProductServiceService } from 'src/app/services/product-service.service';
import { UserServiceService } from 'src/app/user-service.service';
import { AuthServiceService } from 'src/app/auth-service.service';

@Component({
  selector: 'app-bill-history',
  templateUrl: './bill-history.component.html',
  styleUrls: ['./bill-history.component.css']
})
export class BillHistoryComponent implements OnInit {
  adminList:BillHistory[];
  dateList: BillHistory[];
  dateKey: Date
  constructor(private productService:ProductServiceService,private userService:UserServiceService,private authService:AuthServiceService) { }

  ngOnInit() {
    this.productService.getBillHistory(this.authService.userID).subscribe(
      data =>{
      this.adminList=data;
      this.dateList=data;
      console.log(this.adminList);
      });
  }
  searchByDate(){
    if(this.dateKey.toLocaleString().length==0){
      this.dateList=this.adminList;
    }
    else{
     this.dateList=this.adminList.filter(n =>this.dateKey.toLocaleString().match(n.billDate.toLocaleString()));
      console.log(this.dateList);
    }
 
  }

}
