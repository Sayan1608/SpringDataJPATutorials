package com.codingshuttle.jpaTutorial.jpaTuts;

import com.codingshuttle.jpaTutorial.jpaTuts.dto.CProductInfo;
import com.codingshuttle.jpaTutorial.jpaTuts.dto.IProductInfo;
import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import com.codingshuttle.jpaTutorial.jpaTuts.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductProjectionsTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    void testProduct(){
//        List<CProductInfo> products = productRepository.getAllProductInfoConcrete();
//
//        for(CProductInfo p : products){
//            System.out.println(p);
//        }

        productService.testProductPersistanceContext(1L);
    }
}
