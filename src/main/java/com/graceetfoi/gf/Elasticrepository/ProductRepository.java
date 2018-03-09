package com.graceetfoi.gf.Elasticrepository;

import com.graceetfoi.gf.Bean.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product,String> {


    List<Product> findAll();
    List<Product> findByName(String text);
}
