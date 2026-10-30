package com.coding.module1introduction.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name="product_table",
        uniqueConstraints = {
        @UniqueConstraint(
                name = "sku_unique",columnNames = {"sku"}
             ),
        @UniqueConstraint(
                name = "title_price_unique",columnNames = {"title","price"}
                )
        },
        indexes = {
                @Index(name = "idx_sku", columnList="sku")
            }

   )
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private String title;
    @Column(nullable = false ,length = 100)
    private String sku;
    private Integer quantity;
    @Column(name = "created_At")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_At")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
