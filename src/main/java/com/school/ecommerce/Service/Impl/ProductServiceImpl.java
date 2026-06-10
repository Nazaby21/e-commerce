package com.school.ecommerce.Service.Impl;

import com.school.ecommerce.Dto.Request.CreateProductRequestDto;
import com.school.ecommerce.Dto.Request.UpdateProductRequestDto;
import com.school.ecommerce.Dto.Response.ProductResponseDto;
import com.school.ecommerce.Exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.Mapper.ProductMapper;
import com.school.ecommerce.Model.Product;
import com.school.ecommerce.Repository.ProductRepository;
import com.school.ecommerce.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public ProductResponseDto createProduct(CreateProductRequestDto createProductRequestDto) {
        Product product = productMapper.productDtoToEntity(createProductRequestDto);
        Product save = productRepository.save(product);
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
