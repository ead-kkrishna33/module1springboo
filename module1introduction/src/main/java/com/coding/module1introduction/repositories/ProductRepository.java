package com.coding.module1introduction.repositories;

import com.coding.module1introduction.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    ProductEntity findBytitle(String title);
    ProductEntity findBysku(String sku);

    List<ProductEntity> findBy(Sort sortBy);

}
