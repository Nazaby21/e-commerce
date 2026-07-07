package com.school.ecommerce.model;

import com.school.ecommerce.audit.BaseEntity;
import com.school.ecommerce.enumeration.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @Builder.Default
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Status status;
}
