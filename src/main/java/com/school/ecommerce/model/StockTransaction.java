package com.school.ecommerce.model;

import com.school.ecommerce.audit.BaseEntity;
import com.school.ecommerce.enumeration.ReferenceType;
import com.school.ecommerce.enumeration.StockType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "stock_transactions")
public class StockTransaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    @Enumerated(EnumType.STRING)
    @Column(name = "stock_type")
    private StockType stockType;
    private Integer quantity;
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "reference_type")
    private ReferenceType referenceType;
}
