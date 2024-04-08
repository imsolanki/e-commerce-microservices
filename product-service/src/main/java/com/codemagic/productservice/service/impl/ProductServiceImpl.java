package com.codemagic.productservice.service.impl;

import com.codemagic.productservice.dto.ProductDto;
import com.codemagic.productservice.entity.Product;
import com.codemagic.productservice.exception.ProductAlreadyExistException;
import com.codemagic.productservice.exception.ResourceNotFoundException;
import com.codemagic.productservice.repository.ProductRepository;
import com.codemagic.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Optional<Product> optionalProduct = Optional.ofNullable(productRepository.
                findByProductName(productDto.getProductName()));
        if(optionalProduct.isPresent()){
            throw new ProductAlreadyExistException("Product Already Present!!");
        }
        Product product =dtoToEntity(productDto);
        productRepository.save(product);
        return entityToDto(product);
        //return null;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products=productRepository.findAll();
        List<ProductDto> productDtos=products.stream().map(
                product -> entityToDto(product)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ProductDto getProductByName(String productName) {
        Optional<Product> optionalProduct1 = Optional.ofNullable(productRepository.
                findByProductName(productName));
        if(optionalProduct1.isEmpty()){
            throw new ResourceNotFoundException("product","productName",productName);
        }
        Product product = productRepository.findByProductName(productName);
        return entityToDto(product);
        //return null;
    }

    private ProductDto entityToDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    private Product dtoToEntity(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getDescription(),
                productDto.getPrice()
        );
    }
}
