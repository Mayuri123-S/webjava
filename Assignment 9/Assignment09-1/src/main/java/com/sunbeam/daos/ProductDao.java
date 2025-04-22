package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sunbeam.entities.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {}
