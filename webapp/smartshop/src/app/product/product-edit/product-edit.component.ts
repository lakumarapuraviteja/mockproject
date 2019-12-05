import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductServiceService } from 'src/app/services/product-service.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Product } from '../product';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent  {

     editForm: FormGroup;
    productList:Product;
  types = ["Grocery","Fashion","Electronics","Appliances"];

  constructor(private formBuild:FormBuilder,private productService:ProductServiceService,private route : ActivatedRoute,private router:Router) { }

      ngOnInit() {
    const productCode = this.route.snapshot.paramMap.get('code');
       this.productService.getAllProductList(productCode).subscribe(
           (data) =>{
             
           //data.addDate =new Date(data.addDate);
            this.productList=data; 
            console.log('Thevalue of the list is',this.productList);
        this.form();
       })
       
       }
     form(){
     this.editForm = this.formBuild.group({
      productName: [this.productList.productName,[
         Validators.required,
         Validators.minLength(2),
        Validators.maxLength(20)
        ]],
      editURL: [this.productList.image,[
        Validators.required
      ]],
      editBrand: [this.productList.productBrand,[
        Validators.required
       ]],
       editStock: [this.productList.stockCount,[
        Validators.required
       ]],  
       rate: [this.productList.rate,[
        Validators.required
       ]],     

       manufactureDate: [this.productList.manufactureDate,[
         Validators.required
       ]],
       expiryDate: [this.productList.expiryDate,[
        Validators.required
      ]],
      addDate: [this.productList.addDate,[
        Validators.required
      ]],
      type: [this.productList.productType,[
        Validators.required
      ]],
      aisle: [this.productList.aisle,[
        Validators.required
      ]],
      shelf: [this.productList.shelf,[
        Validators.required
      ]]
     })
   }

     get productName() {
    return this.editForm.get('productName');
    }
    get editURL() {
     return this.editForm.get('editURL');
    }
   get editBrand() {
     return this.editForm.get('editBrand');
   }
   get editStock() {
    return this.editForm.get('editStock');
  }
   get rate() {
     return this.editForm.get('rate');
   }
   get manufactureDate() {
    return this.editForm.get('manufactureDate');
  }
  get expiryDate() {
    return this.editForm.get('expiryDate');
  }
  get addDate() {
    return this.editForm.get('addDate');
  }
  get type() {
    return this.editForm.get('type');
  }
  get aisle() {
    return this.editForm.get('aisle');
  }
  get shelf() {
    return this.editForm.get('shelf');
  }
  
  
  onSaveClick() {
    let newList:Product = {productCode:this.productList.productCode,productName:this.editForm.value["productName"],productBrand:this.editForm.value["editBrand"],rate:this.editForm.value["rate"],
    stockCount:+this.editForm.value["editStock"],addDate:this.editForm.value["addDate"],aisle:this.editForm.value["aisle"],shelf:this.editForm.value["shelf"],manufactureDate:this.editForm.value["manufactureDate"],expiryDate:this.editForm.value["expiryDate"],
    image:this.editForm.value["editURL"],productType:this.editForm.value["type"],productTypeImage:null,quantity:null}
    console.log(newList) 
    this.productService.modifyProduct(newList).subscribe(
        (data) =>{
         newList=data; });
     this.router.navigate(['search-box'])
   }


}
