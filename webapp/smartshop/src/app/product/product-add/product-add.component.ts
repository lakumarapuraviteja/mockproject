import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductServiceService } from 'src/app/services/product-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  editForm: FormGroup;
  prodItem: Product;
  types = ["Electronics", "Grocery", "Furniture", "Fashion"];

  constructor(private formBuild: FormBuilder, private productService: ProductServiceService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.form();
  }
  form() {
    // this.foodItem.dateOfLaunch.setDate(this.foodItem.dateOfLaunch.getDate()+1);
    this.editForm = this.formBuild.group({
      editName: ['', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(20)
      ]],
      editURL: ['', [
        Validators.required
      ]],
      editCode: ['', [
        Validators.required
      ]],
      editBrand: ['', [
        Validators.required
      ]],
      editStock: ['', [
        Validators.required
      ]],
      rate: ['', [
        Validators.required
      ]],
      manufactureDate: ['', [
        Validators.required
      ]],
      expiryDate: ['', [
        Validators.required
      ]],
      addDate: ['', [
        Validators.required
      ]],
      type: ['', [
        Validators.required
      ]],
      aisle: ['', [
        Validators.required
      ]],
      shelf: ['', [
        Validators.required
      ]],
    })
  }

  get editName() {
    return this.editForm.get('editName');
  }
  get editCode() {
    return this.editForm.get('editCode');
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
  get type() {
    return this.editForm.get('type');
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
  get aisle() {
    return this.editForm.get('aisle');
  }
  get shelf() {
    return this.editForm.get('shelf');
  }

  onSaveClick() {
    let item: Product =
    {
      productCode: this.editForm.value["editCode"],
      productName: this.editForm.value["editName"],
      productBrand: this.editForm.value["editBrand"],
      stockCount: this.editForm.value["editStock"],
      rate: this.editForm.value["rate"],
      manufactureDate:this.editForm.value["manufactureDate"],
      expiryDate: this.editForm.value["expiryDate"],
      addDate: this.editForm.value["addDate"],
      productType: this.editForm.value["type"],
      image :this.editForm.value["editURL"],
      aisle: this.editForm.value["aisle"],
      shelf: this.editForm.value["shelf"],
      productTypeImage:null,
      quantity:null
    }
    this.productService.addProducts(item).subscribe();
    this.router.navigate(['search-box'])
  }

}
