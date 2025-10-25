package com.codingshuttle.jpaTutorial.jpaTuts.repositories;

import com.codingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title);

    List<ProductEntity> findByQuantityGreaterThanAndPriceBetween(Integer quantity, BigDecimal startingPrice, BigDecimal endingPrice);

    @Query("Select e from ProductEntity e where e.createdAt between ?1 and ?2")
    List<ProductEntity> findByCreatedAtDate(LocalDateTime startTime, LocalDateTime endTime);

    // sorting functionality
    List<ProductEntity> findByOrderByPrice();

    List<ProductEntity> findBy(Sort sort);
}
