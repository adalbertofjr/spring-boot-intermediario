package com.adalbertofjr.RestAPI.resources;

import com.adalbertofjr.RestAPI.models.Product;
import com.adalbertofjr.RestAPI.services.ProductService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    public ProductResource(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    @ResponseBody
    public List<Product> findAll(){
        return this.productService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Optional<Product> find(@PathVariable(value = "id") Long id){
        return this.productService.find(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
        return this.productService.create(product);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public Optional<Product> update(@PathVariable(value = "id") Long id, @RequestBody Product product){
        return this.productService.update(id, product);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") Long id){
            this.productService.delete(id);
    }

}
