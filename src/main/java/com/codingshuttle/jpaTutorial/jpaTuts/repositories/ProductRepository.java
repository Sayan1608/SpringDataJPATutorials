package com.codingshuttle.jpaTutorial.jpaTuts.repositories;

import com.codingshuttle.jpaTutorial.jpaTuts.dto.CProductInfo;
import com.codingshuttle.jpaTutorial.jpaTuts.dto.IProductInfo;
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

    @Query("select p.sku as sku, p.title as title, p.price as price from ProductEntity p")
    List<IProductInfo> getAllProductInfo();

    @Query("select new com.codingshuttle.jpaTutorial.jpaTuts.dto.CProductInfo(p.sku, p.title, p.price) from ProductEntity p")
    List<CProductInfo> getAllProductInfoConcrete();
}
