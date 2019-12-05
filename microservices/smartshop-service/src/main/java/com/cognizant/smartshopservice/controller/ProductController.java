package com.cognizant.smartshopservice.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshopservice.model.Bill;
import com.cognizant.smartshopservice.model.Product;
import com.cognizant.smartshopservice.security.AppUserDetailsService;
import com.cognizant.smartshopservice.service.ProductService;


@RestController
@RequestMapping("/search-box")
public class ProductController {

       @Autowired
       ProductService productService;
       @Autowired
       private AppUserDetailsService appUserDetailsService;

       @GetMapping("")
       public List<String> getAllProductTypes(){
              return productService.getAllProductTypes();
       }
       
       @GetMapping("{name}")
       public List<Product> ProductList(@PathVariable("name") String type){
              return productService.ProductList(type);
       }
       
       @GetMapping("/product-edit/{code}")
       public Product getAllProductList(@PathVariable("code") String code){
              return productService.getAllProducts(code);
       }
       @PutMapping("")
       public void modifyProducts(@RequestBody Product product){
    	 productService.modifyProducts(product);  
       }
      
       @PostMapping("/add")
       public void productAdd(@RequestBody Product product){
    	   productService.productAdd(product);
    	   
       }
       @DeleteMapping("/delete/{code}")
       public void productDelete(@PathVariable("code") String code){
    	   productService.productDelete(code);
    	   
       }
       
       @GetMapping("/all")
       public List<Product> getAll(){
    	   return productService.getAll();
       }
       
       @PostMapping("/bill/{name}/{code}/{quants}")
              public void postBill(@PathVariable("name") String name,@PathVariable("code") String code,@PathVariable("quants") int quants){
                     productService.postBill(name,code,quants);
              }
              @GetMapping("/bill/{name}")
              public Set<Bill> getBill(@PathVariable("name") String name){
                     return productService.getBill(name);
              }

     
       
      
}
