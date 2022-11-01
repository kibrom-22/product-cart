package com.generation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.generation.model.Cart;
@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{

}
