package com.adalbertofjr.RestAPI.resources;

import com.adalbertofjr.RestAPI.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @GetMapping
    @ResponseBody
    public List<Product> findAll(){
        return null;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Product find(@PathVariable(value = "id") Long id){
        return null;
    }

    @PostMapping
    @ResponseBody
    public Product create(@RequestBody Product product){
        return null;
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public Product update(@PathVariable(value = "id") Long id,@RequestBody Product product){
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id){

    }

}
