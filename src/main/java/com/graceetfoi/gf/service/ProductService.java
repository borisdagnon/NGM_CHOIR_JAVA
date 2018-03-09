package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Product;
import com.graceetfoi.gf.Elasticrepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
      return productRepository.findAll();
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);


    }
}
