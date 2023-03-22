package com.sha.springbootmicroserviceproduct.Service;

import com.sha.springbootmicroserviceproduct.Entity.Product;
import com.sha.springbootmicroserviceproduct.Model.ProductDto;
import com.sha.springbootmicroserviceproduct.Reposiyory.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IProductService {
    private final IProductRepository productRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ProductServiceImp(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product entity = modelMapper.map(productDto, Product.class);
        entity.setCreatedAt(LocalDateTime.now());
        return modelMapper.map(productRepository.save(entity), ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product entity = modelMapper.map(productDto, Product.class);
        entity.setUpdatedAt(LocalDateTime.now());
        return modelMapper.map(productRepository.save(entity), ProductDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
       productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream().
                map(entity -> modelMapper.map(entity, ProductDto.class)).collect(Collectors.toList());
    }
}
