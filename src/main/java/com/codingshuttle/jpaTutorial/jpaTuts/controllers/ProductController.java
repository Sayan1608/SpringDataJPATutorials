package com.codingshuttle.jpaTutorial.jpaTuts.controllers;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController {
    private static final int PAGE_SIZE = 5;
    private final ProductRepository productRepository;
    @GetMapping
    public Page<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id")String sortBy,
                                              @RequestParam(defaultValue = "asc")String direction,
                                              @RequestParam(defaultValue = "0")Integer pageNumber){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
//        return productRepository.findBy(Sort.by(sortDirection,sortBy));
//        return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy)));

        Pageable pageable = PageRequest.of(pageNumber,PAGE_SIZE, Sort.by(sortDirection,sortBy));
        return productRepository.findAll(pageable);
    }

}
