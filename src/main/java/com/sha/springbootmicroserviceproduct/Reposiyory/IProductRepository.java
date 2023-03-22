package com.sha.springbootmicroserviceproduct.Reposiyory;

import com.sha.springbootmicroserviceproduct.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IProductRepository extends JpaRepository<Product, Long> {

}
