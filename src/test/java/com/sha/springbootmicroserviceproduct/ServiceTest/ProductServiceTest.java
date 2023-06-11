package com.sha.springbootmicroserviceproduct.ServiceTest;


import com.sha.springbootmicroserviceproduct.Entity.Product;
import com.sha.springbootmicroserviceproduct.Model.ProductDto;
import com.sha.springbootmicroserviceproduct.Reposiyory.IProductRepository;
import com.sha.springbootmicroserviceproduct.Service.IProductService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class ProductServiceTest {
    @InjectMocks
    private IProductService productService = mock(IProductService.class);
    @Mock
    private IProductRepository productRepository = mock(IProductRepository.class);
    @Mock
    ModelMapper modelMapper=mock(ModelMapper.class);

    @Test
    void saveProduct_Then_ReturnProduct() {
        var product = new Product();
        product.setName("product1");
        product.setId(1L);
        product.setVersion(0);
        product.setPrice(99D);

        var productDto = new ProductDto();
        productDto.setName("product1");
        productDto.setId(1L);
        productDto.setVersion(0);
        productDto.setPrice(99D);

        var savedProduct = productService.saveProduct(productDto);
        when(modelMapper.map(productDto,Product.class)).thenReturn(product);
        when(modelMapper.map(product,ProductDto.class)).thenReturn(productDto);
        when(productRepository.save(Mockito.any(Product.class))).thenReturn(Mockito.any(Product.class));
    }
}
