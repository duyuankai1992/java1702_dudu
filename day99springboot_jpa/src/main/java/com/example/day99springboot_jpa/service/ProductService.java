package com.example.day99springboot_jpa.service;

import com.example.day99springboot_jpa.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public Page<Product> findProductPaging(Pageable pageable);
}
