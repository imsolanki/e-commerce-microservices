package com.codemagic.productservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    @NotEmpty
    @Size(min=4,message = "Product must have at least 4 characters")
    private String productName;
    @NotEmpty
    @Size(min=4,message = "Product must have at least 10 characters")
    private String description;
    @NotEmpty
    private double price;
}
