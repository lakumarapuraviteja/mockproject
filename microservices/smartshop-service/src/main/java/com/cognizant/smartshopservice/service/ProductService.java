package com.cognizant.smartshopservice.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smartshopservice.model.Bill;
import com.cognizant.smartshopservice.model.Product;
import com.cognizant.smartshopservice.model.User;
import com.cognizant.smartshopservice.repository.ProductRepository;
import com.cognizant.smartshopservice.repository.UserRepository;

@Service
public class ProductService {

       @Autowired
       ProductRepository productRepository;
       
       @Autowired
       UserRepository userRepository;

       public List<String> getAllProductTypes() {
              // TODO Auto-generated method stub
              return productRepository.getAllProductTypes();
       }
       public List<Product> ProductList(String type) {
           // TODO Auto-generated method stub
    	   //Product product = new Product();
           return productRepository.getProductList(type);
    }
       public Product getAllProducts(String code) {
           // TODO Auto-generated method stub
    	   //Product product = new Product();
           return productRepository.getAllProducts(code);
    }
	public void modifyProducts(Product product) {
		
		productRepository.save(product);
	}
	public void productAdd(Product product) {
		productRepository.save(product);
		
	}
	public void productDelete(String code) {
		// TODO Auto-generated method stub
		productRepository.deleteById(code);
		
	}
	public List<Product> getAll(){
		return productRepository.getAll();
	}
	
	public void postBill(String name,String code,int quants){
        Bill bill=new Bill();
        User user = userRepository.findByUser(name);
       // LOGGER.debug("user",user);
        Product pro=productRepository.findById(code).get();
       // LOGGER.debug("pro",pro);
        bill.setUser(user);
        bill.setProduct(pro);
        bill.setQuantity(quants);
        bill.setBillDate(new Date(System.currentTimeMillis()));
        Set<Bill> billList = user.getBillList();
       // LOGGER.debug("bill",bill);
        billList.add(bill);
        user.setBillList(billList);
        userRepository.save(user);
        pro.setStockCount(pro.getStockCount()-quants);
        productRepository.save(pro);

        
 }
 public Set<Bill> getBill(String name){
        //return userRepository.getBill(name);
        User user=userRepository.findByUsername(name);
        
        return user.getBillList();
 }

       
}
