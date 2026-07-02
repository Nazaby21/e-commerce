package com.school.ecommerce.service.impl;

import com.school.ecommerce.dto.request.CreateProductRequestDto;
import com.school.ecommerce.dto.request.UpdateProductRequestDto;
import com.school.ecommerce.dto.response.ProductResponseDto;
import com.school.ecommerce.exception.Custom.ResourceAlreadyExistsException;
import com.school.ecommerce.exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.mapper.ProductMapper;
import com.school.ecommerce.model.Product;
import com.school.ecommerce.model.StockBalance;
import com.school.ecommerce.model.User;
import com.school.ecommerce.repository.CategoryRepository;
import com.school.ecommerce.repository.ProductRepository;
import com.school.ecommerce.repository.StockBalanceRepository;
import com.school.ecommerce.repository.UserRepository;
import com.school.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final StockBalanceRepository stockBalanceRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public ProductResponseDto createProduct(CreateProductRequestDto createProductRequestDto) {
        if (productRepository.existsByProductName(createProductRequestDto.getProductName())) {
            throw ResourceAlreadyExistsException.byName("Product", "product name", createProductRequestDto.getProductName());
        }
        userRepository.findById(createProductRequestDto.getUserId())
                .orElseThrow(() -> ResourceNotFoundException.byId("User", createProductRequestDto.getUserId()));
        categoryRepository.findById(createProductRequestDto.getCategoryId())
                .orElseThrow(() -> ResourceNotFoundException.byId("Category", createProductRequestDto.getCategoryId()));
        Product product = productMapper.productDtoToEntity(createProductRequestDto);
        Product save = productRepository.save(product);
        StockBalance stockBalance = new StockBalance();
        stockBalance.setProduct(save);
        stockBalance.setQuantity(0);
        stockBalanceRepository.save(stockBalance);
        return productMapper.productEntityToDto(save);
    }

    @Override
    public ProductResponseDto updateProduct(Long id, UpdateProductRequestDto updateProductRequestDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.byId("Product", id ));

        productMapper.updateProductFromDto(updateProductRequestDto, product);
        Product save = productRepository.save(product);
        return productMapper.productEntityToDto(save);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.byId("Product", id ));
        return productMapper.productEntityToDto(product);
    }

    @Override
    public List<ProductResponseDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::productEntityToDto)
                .toList();
    }

    @Override
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.byId("Product", id ));
        productRepository.delete(product);
    }
}
