package com.codemagic.productservice.service;

import com.codemagic.productservice.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProduct();

    ProductDto getProductByName(String productName);
}
