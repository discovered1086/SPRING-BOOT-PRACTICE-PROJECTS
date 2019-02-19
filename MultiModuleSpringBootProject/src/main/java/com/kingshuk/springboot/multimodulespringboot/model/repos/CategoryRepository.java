package com.kingshuk.springboot.multimodulespringboot.model.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
