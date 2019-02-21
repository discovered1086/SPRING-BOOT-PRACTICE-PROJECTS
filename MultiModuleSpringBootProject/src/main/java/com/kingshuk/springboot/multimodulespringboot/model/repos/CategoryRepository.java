package com.kingshuk.springboot.multimodulespringboot.model.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kingshuk.springboot.multimodulespringboot.model.entities.Category;

@RepositoryRestResource(path="categories")
public interface CategoryRepository extends JpaRepository<Category, String> {

}
