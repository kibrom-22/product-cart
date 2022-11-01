package com.generation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.generation.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
