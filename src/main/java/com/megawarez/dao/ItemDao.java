package com.megawarez.dao;

import com.megawarez.domain.Item;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemDao extends CrudRepository<Item, Integer> {

    @Modifying
    @Query("update Item itm set itm.name = :name where itm.id = :id")
    public void updateName(
            @Param(value = "id") Integer id,
            @Param(value = "name") String name
    );
}