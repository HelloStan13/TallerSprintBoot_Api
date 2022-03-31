package com.megawarez.dao;

import com.megawarez.domain.SubCategory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SubCategoryDao extends CrudRepository<SubCategory, Integer> {

    @Modifying
    @Query("update SubCategory subcat set subcat.name = :name where subcat.id = :id")
    public void updateName(
            @Param(value = "id") Integer id,
            @Param(value = "name") String name
    );
}