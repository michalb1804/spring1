package com.web.spring1.service;

import com.web.spring1.model.Product;
import com.web.spring1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {

        return productRepository.save(product);
    }

    public List<Product> findAll() {

        return productRepository.findAll();
    }

    public Product findById(Integer id) {

        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> saveAll(List<Product> products) {

        return productRepository.saveAll(products);
    }

    public void delete(Integer id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }
    }


}
