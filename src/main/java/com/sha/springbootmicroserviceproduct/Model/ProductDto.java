package com.sha.springbootmicroserviceproduct.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDto extends BaseDto {

    private String name;

    private Double price;
}
