package com.adalbertofjr.RestAPI.resources;

import com.adalbertofjr.RestAPI.models.Product;
import com.adalbertofjr.RestAPI.services.ProductService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Find all products")
    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findAll() {
        List<Product> products = this.productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Operation(summary = "Find a product by id")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> find(@PathVariable(value = "id") Long id) {
        Optional<Product> product = this.productService.find(id);
        return new ResponseEntity<Optional<Product>>(product, HttpStatus.OK);
    }

    @Operation(summary = "Create a new product")
    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Product product, Errors errors) {
        if (!errors.hasErrors()) {
            Product productCreated = this.productService.create(product);
            return new ResponseEntity<Product>(productCreated, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().body(errors
                .getAllErrors()
                .stream()
                .map(msg -> msg.getDefaultMessage())
                .collect(Collectors.joining(",")));
    }

    @Operation(summary = "Update the product with id")
    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Product product, Errors errors) {
        if (!errors.hasErrors()) {
            Optional<Product> productUpdated = this.productService.update(id, product);
            return new ResponseEntity<Optional<Product>>(productUpdated, HttpStatus.OK);
        }

        return ResponseEntity.badRequest().body(errors
                .getAllErrors()
                .stream()
                .map(msg -> msg.getDefaultMessage())
                .collect(Collectors.joining(",")));
    }

    @Operation(summary = "Delete a product")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") Long id) {
        this.productService.delete(id);
    }

}
