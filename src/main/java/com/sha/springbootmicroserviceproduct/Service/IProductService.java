package com.sha.springbootmicroserviceproduct.Service;

import com.sha.springbootmicroserviceproduct.Model.ProductDto;

import java.util.List;

public interface IProductService {
    public ProductDto saveProduct(ProductDto productDto);

    public ProductDto updateProduct(ProductDto productDto);

    public void deleteProduct(Long id);

    public List<ProductDto> findAllProducts();
}
