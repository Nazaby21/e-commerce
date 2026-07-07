package com.school.ecommerce.service.impl;

import com.school.ecommerce.dto.request.CreateOrderItemRequestDto;
import com.school.ecommerce.dto.request.CreateOrderRequestDto;
import com.school.ecommerce.dto.response.OrderResponseDto;
import com.school.ecommerce.enumeration.ReferenceType;
import com.school.ecommerce.enumeration.Status;
import com.school.ecommerce.enumeration.StockType;
import com.school.ecommerce.exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.mapper.OrderMapper;
import com.school.ecommerce.model.*;
import com.school.ecommerce.repository.*;
import com.school.ecommerce.service.OrderService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final StockBalanceRepository stockBalanceRepository;
    private final StockTransactionRepository stockTransactionRepository;

    @Override
    public OrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {
        User buyer = userRepository.findById(createOrderRequestDto.getBuyerId())
                .orElseThrow(() -> ResourceNotFoundException.byId("User", createOrderRequestDto.getBuyerId()));

        Order order = Order.builder()
                .buyer(buyer)
                .status(Status.PENDING)
                .build();

        double totalPrice = 0;

        for(CreateOrderItemRequestDto itemRequestDto : createOrderRequestDto.getItems()) {
            Product product = productRepository.findById(itemRequestDto.getProductId())
                    .orElseThrow(() -> ResourceNotFoundException.byId("Product", itemRequestDto.getProductId()));

            StockBalance stockBalance = stockBalanceRepository.findByProductId(product.getId())
                    .orElseThrow(() -> ResourceNotFoundException.byId("StockBalance", product.getId()));

            if (stockBalance.getQuantity() < itemRequestDto.getQuantity()) {
                throw new ValidationException("Insufficient stock.");
            }

            stockBalance.setQuantity(
                    stockBalance.getQuantity() - itemRequestDto.getQuantity()
            );

            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequestDto.getQuantity())
                    .unitPrice(product.getPrice())
                    .build();

            order.getOrderItems().add(orderItem);
            totalPrice += product.getPrice() * itemRequestDto.getQuantity();

            StockTransaction transaction = StockTransaction.builder()
                    .product(product)
                    .stockType(StockType.OUT_STOCK)
                    .quantity(itemRequestDto.getQuantity())
                    .referenceType(ReferenceType.ORDER)
                    .transactionDate(LocalDateTime.now())
                    .build();
            stockTransactionRepository.save(transaction);
        }

        order.setTotalPrice(totalPrice);
        Order savedOrder = orderRepository.save(order);

        return orderMapper.orderEntityToDto(savedOrder);
    }
}
