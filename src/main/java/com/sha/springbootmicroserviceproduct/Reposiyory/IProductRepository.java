package com.sha.springbootmicroserviceproduct.Reposiyory;

import com.sha.springbootmicroserviceproduct.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProductRepository extends JpaRepository<Product, UUID> {

}
