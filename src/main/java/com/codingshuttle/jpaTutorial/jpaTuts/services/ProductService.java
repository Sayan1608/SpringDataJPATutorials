package com.codingshuttle.jpaTutorial.jpaTuts.services;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void testProductPersistanceContext(Long id){
        ProductEntity product1 = productRepository.findById(id).orElseThrow();
        ProductEntity product2 = productRepository.findById(id).orElseThrow();

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product1 == product2);

        product1.setTitle("Random Title");
    }
}
