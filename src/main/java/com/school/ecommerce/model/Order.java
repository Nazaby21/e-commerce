package com.school.ecommerce.model;

import com.school.ecommerce.audit.BaseEntity;
import com.school.ecommerce.enumeration.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @Column(name = "total_price")
    private Double totalPrice;
    @Enumerated(EnumType.STRING)
    private Status status;
}
