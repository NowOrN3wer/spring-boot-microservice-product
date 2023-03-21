package com.sha.springbootmicroserviceproduct.Controller;

import com.sha.springbootmicroserviceproduct.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product") //pre path
public class ProductController {
    @Autowired
    private IProductService productService;

    public Respı

}
