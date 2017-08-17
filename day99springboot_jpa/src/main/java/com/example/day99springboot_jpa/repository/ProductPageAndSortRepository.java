package com.example.day99springboot_jpa.repository;

import com.example.day99springboot_jpa.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductPageAndSortRepository extends PagingAndSortingRepository<Product,String> {
}
