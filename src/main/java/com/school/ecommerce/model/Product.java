package com.school.ecommerce.model;

import com.school.ecommerce.audit.BaseEntity;
import com.school.ecommerce.enumeration.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "product_name")
    private String productName;
    private String description;
    @Column(name = "product_price")
    private Double productPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<StockTransaction> stockTransactions;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Status status;
}
