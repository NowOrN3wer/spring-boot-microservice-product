package com.sha.springbootmicroserviceproduct.Service;

import com.sha.springbootmicroserviceproduct.Entity.Product;
import com.sha.springbootmicroserviceproduct.Model.ProductDto;
import com.sha.springbootmicroserviceproduct.Reposiyory.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
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
        var entity = modelMapper.map(productDto, Product.class);
        return modelMapper.map(productRepository.save(entity), ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        var entity = modelMapper.map(productDto, Product.class);
        return modelMapper.map(productRepository.save(entity), ProductDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
       productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().
                map(entity -> modelMapper.map(entity, ProductDto.class)).
                collect(Collectors.toList()).stream().
                sorted(Comparator.comparing(ProductDto::getId)).collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Long id) {
        return modelMapper.map(productRepository.findById(id), ProductDto.class);
    }
}
