package com.sha.springbootmicroserviceproduct.Service;

import com.sha.springbootmicroserviceproduct.Model.ProductDto;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    public ProductDto saveProduct(ProductDto productDto);

    public ProductDto updateProduct(ProductDto productDto);

    public void deleteProduct(UUID productUuid);

    public List<ProductDto> findAllProducts();
}
