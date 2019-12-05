package com.cognizant.smartshopservice;

import java.util.List;
import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.cognizant.smartshopservice.controller.ProductController;
import com.cognizant.smartshopservice.model.Product;
import com.cognizant.smartshopservice.repository.ProductRepository;
import com.cognizant.smartshopservice.service.ProductService;


@FixMethodOrder
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class SmartshopServiceApplicationTests {

	@Autowired
    ProductRepository productrepository;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    ProductController productController;
    
    @Autowired
    private MockMvc mvc;
    
    /*void contextLoads(){
                    
    }*/
    
    @Test
public void testGetProductList(){
        List<Product> products = productrepository.getProductList("Electronics");
        assertEquals(products.isEmpty(), false);               
}
    
    @Test
    public void testProductDelete(){
           productService.productDelete("A7");
                    Product product=productService.getAllProducts("A7");
                    assertNotNull(product); 
    }
    
    @Test
    public void testGetAll() throws Exception{
                    ResultActions actions=mvc.perform(get("/searchbox/all"));
                    actions.andExpect(status().isOk());
    }



}
