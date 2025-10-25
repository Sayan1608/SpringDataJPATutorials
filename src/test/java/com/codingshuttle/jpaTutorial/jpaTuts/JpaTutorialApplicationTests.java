package com.codingshuttle.jpaTutorial.jpaTuts;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testSaveRepository(){
		ProductEntity product = ProductEntity.builder()
				.sku("parle123")
				.title("Parle Hide & Seek Choco Chip Biscuits")
				.price(BigDecimal.valueOf(35.55))
				.quantity(10)
				.build();

		ProductEntity savedProduct = productRepository.save(product);
		System.out.println(savedProduct);
	}

	@Test
	void testGetRepository(){
		List<ProductEntity> products = productRepository.findAll();
		products.forEach(System.out::println);
	}

	@Test
	void testNamedQuery(){
//		List<ProductEntity> titledProducts = productRepository.findByTitleContainingIgnoreCase("biscuit");
//		List<ProductEntity> byQuantityGreaterThanAndPriceBetween = productRepository.findByQuantityGreaterThanAndPriceBetween(2, BigDecimal.valueOf(10), BigDecimal.valueOf(20));
		List<ProductEntity> byCreatedAtDate = productRepository.findByCreatedAtDate(LocalDateTime.of(2025, 10, 22, 0, 0, 0), LocalDateTime.of(2025, 10, 26, 0, 0, 0));
		System.out.println(byCreatedAtDate);
	}


}
