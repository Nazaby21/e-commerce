package com.school.ecommerce.Controller;

import com.school.ecommerce.Dto.Request.CreateProductRequestDto;
import com.school.ecommerce.Dto.Request.UpdateProductRequestDto;
import com.school.ecommerce.Dto.Response.ProductResponseDto;
import com.school.ecommerce.Exception.Dto.ApiResponse;
import com.school.ecommerce.Mapper.ProductMapper;
import com.school.ecommerce.Service.ProductService;
import com.school.ecommerce.Vo.Request.CreateProductRequestVo;
import com.school.ecommerce.Vo.Request.UpdateProductRequestVo;
import com.school.ecommerce.Vo.Response.ProductResponseVo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ApiResponse<ProductResponseVo> createProduct(@RequestBody CreateProductRequestVo createProductRequestVo){
        CreateProductRequestDto createProductRequestDto = productMapper.createdProductVoToDto(createProductRequestVo);
        ProductResponseDto product = productService.createProduct(createProductRequestDto);
        ProductResponseVo productResponseVo = productMapper.productDtoToVo(product);
        return ApiResponse.success(productResponseVo);
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductResponseVo> updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequestVo updateProductRequestVo){
        UpdateProductRequestDto updateProductRequestDto = productMapper.updatedProductVoToDto(updateProductRequestVo);
        ProductResponseDto product = productService.updateProduct(id, updateProductRequestDto);
        ProductResponseVo productResponseVo = productMapper.productDtoToVo(product);
        return ApiResponse.success(productResponseVo);
    }

    @GetMapping
    public ApiResponse<List<ProductResponseVo>> getProducts(){
        List<ProductResponseVo> productResponseVos = productService.getProducts()
                .stream()
                .map(productMapper::productDtoToVo)
                .toList();
        return ApiResponse.success(productResponseVos);
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponseVo> getProductById(@PathVariable Long id){
        ProductResponseDto productById = productService.getProductById(id);
        ProductResponseVo productResponseVo = productMapper.productDtoToVo(productById);
        return ApiResponse.success(productResponseVo);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return "Product with id: " + id + " has been deleted";
    }

}
