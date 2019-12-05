package com.cognizant.smartshopservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cognizant.smartshopservice.model.Product;



public interface ProductRepository extends JpaRepository<Product, String> {
       @Query(value = "select distinct p.productType from Product p")
       List<String> getAllProductTypes();
       
       @Query(value= "From Product p  where p.productType=?1")
       List<Product> getProductList(String type);
       
      @Query(value= "From Product p where p.productCode=?1")
       Product getAllProducts(String code);
      
      @Query(value="select p From Product p")
      List<Product> getAll();
     
}


