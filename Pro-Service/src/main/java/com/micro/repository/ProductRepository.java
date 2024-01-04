package com.micro.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.micro.model.Product;



public interface ProductRepository extends MongoRepository <Product, Long > {

}