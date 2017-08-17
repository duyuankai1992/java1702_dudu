package com.example.day99springboot_jpa.service;

import com.example.day99springboot_jpa.domain.Product;
import com.example.day99springboot_jpa.repository.ProductPageAndSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductPageAndSortRepository repository;

    @Override
    public Page<Product> findProductPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
