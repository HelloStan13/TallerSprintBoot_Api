package com.megawarez.dao;

import com.megawarez.domain.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryDao extends CrudRepository<Category, Integer> {

    @Modifying
    @Query("update Category cat set cat.name = :name where cat.id = :id")
    public void updateName(
            @Param(value = "id") Integer id,
            @Param(value = "name") String name
    );
}