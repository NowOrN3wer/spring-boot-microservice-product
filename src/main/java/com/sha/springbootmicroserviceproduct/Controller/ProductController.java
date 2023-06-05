package com.sha.springbootmicroserviceproduct.Controller;

import com.sha.springbootmicroserviceproduct.Model.ProductDto;
import com.sha.springbootmicroserviceproduct.Service.IProductService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product/") //pre path
public class ProductController {
    private final IProductService productService;

    ProductController(IProductService productService){
        this.productService = productService;
    }
    @PostMapping("save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.updateProduct(productDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getAll")
    ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    ResponseEntity<?> getById(@PathVariable @NotNull Long id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }
}
