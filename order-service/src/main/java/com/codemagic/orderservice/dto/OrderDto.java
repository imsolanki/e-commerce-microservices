package com.codemagic.orderservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String orderId;
    @NotEmpty
    @Size(min = 4,message = "ProductName must be of at least 4 characters")
    private String productName;
    @NotNull
    private int qty;
    @NotNull
    private double price;
}
