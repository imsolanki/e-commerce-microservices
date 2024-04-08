package com.codemagic.inventoryservice.dto;

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
public class InventoryDto {
    private Long id;
    @NotEmpty
    @Size(min=4,message = "Product must have at least 4 characters")
    private String productName;
    @NotNull
    private Integer quantity;
}
