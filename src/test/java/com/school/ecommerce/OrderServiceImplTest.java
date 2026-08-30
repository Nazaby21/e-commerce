package com.school.ecommerce;

import com.school.ecommerce.dto.request.CreateOrderItemRequestDto;
import com.school.ecommerce.dto.request.CreateOrderRequestDto;
import com.school.ecommerce.dto.response.OrderResponseDto;
import com.school.ecommerce.exception.business.InsufficientStockException;
import com.school.ecommerce.exception.business.ResourceNotFoundException;
import com.school.ecommerce.mapper.OrderMapper;
import com.school.ecommerce.model.Order;
import com.school.ecommerce.model.Product;
import com.school.ecommerce.model.StockBalance;
import com.school.ecommerce.model.User;
import com.school.ecommerce.repository.*;
import com.school.ecommerce.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderMapper orderMapper;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private StockBalanceRepository stockBalanceRepository;
    @Mock
    private StockTransactionRepository stockTransactionRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private User buyer;
    private Product product;
    private StockBalance stockBalance;

    @BeforeEach
    void setUp() {
        buyer = new User();
        buyer.setId(1L);
        buyer.setUsername("john");
        buyer.setEmail("john@example.com");

        product = new Product();
        product.setId(10L);
        product.setName("Laptop");
        product.setPrice(1200.0);

        stockBalance = new StockBalance();
        stockBalance.setId(100L);
        stockBalance.setProduct(product);
        stockBalance.setQuantity(5);
    }

    @Test
    void createOrder_Success() {
        CreateOrderItemRequestDto itemDto = new CreateOrderItemRequestDto();
        itemDto.setProductId(10L);
        itemDto.setQuantity(2);

        CreateOrderRequestDto orderDto = new CreateOrderRequestDto();
        orderDto.setBuyerId(1L);
        orderDto.setItems(List.of(itemDto));

        when(userRepository.findById(1L)).thenReturn(Optional.of(buyer));
        when(productRepository.findById(10L)).thenReturn(Optional.of(product));
        when(stockBalanceRepository.findByProductId(10L)).thenReturn(Optional.of(stockBalance));
        when(orderRepository.save(any(Order.class))).thenAnswer(i -> {
            Order o = i.getArgument(0);
            o.setId(99L);
            return o;
        });

        OrderResponseDto expectedResponse = new OrderResponseDto();
        expectedResponse.setOrderId(99L);
        expectedResponse.setTotalPrice(2400.0);
        when(orderMapper.orderEntityToDto(any(Order.class))).thenReturn(expectedResponse);

        OrderResponseDto result = orderService.createOrder(orderDto);

        assertNotNull(result);
        assertEquals(99L, result.getOrderId());
        assertEquals(2400.0, result.getTotalPrice());
        // Stock should be reduced from 5 to 3
        assertEquals(3, stockBalance.getQuantity());
    }

    @Test
    void createOrder_ThrowsInsufficientStockException() {
        CreateOrderItemRequestDto itemDto = new CreateOrderItemRequestDto();
        itemDto.setProductId(10L);
        itemDto.setQuantity(10); // More than available 5

        CreateOrderRequestDto orderDto = new CreateOrderRequestDto();
        orderDto.setBuyerId(1L);
        orderDto.setItems(List.of(itemDto));

        when(userRepository.findById(1L)).thenReturn(Optional.of(buyer));
        when(productRepository.findById(10L)).thenReturn(Optional.of(product));
        when(stockBalanceRepository.findByProductId(10L)).thenReturn(Optional.of(stockBalance));

        assertThrows(InsufficientStockException.class, () -> orderService.createOrder(orderDto));
    }

    @Test
    void createOrder_ThrowsResourceNotFoundException_WhenBuyerNotFound() {
        CreateOrderRequestDto orderDto = new CreateOrderRequestDto();
        orderDto.setBuyerId(999L);
        orderDto.setItems(List.of());

        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> orderService.createOrder(orderDto));
    }
}
