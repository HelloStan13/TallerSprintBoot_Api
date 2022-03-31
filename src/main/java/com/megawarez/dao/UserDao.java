package com.megawarez.dao;

import com.megawarez.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.Instant;

public interface UserDao extends CrudRepository<User, Integer> {

    @Modifying
    @Query("update User user set user.username = :username where user.id = :id")
    public void updateUsername(
            @Param(value = "id") Integer id,
            @Param(value = "username") String username
    );

    @Modifying
    @Query("update User user set user.password = :password where user.id = :id")
    public void updatePassword(
            @Param(value = "id") Integer id,
            @Param(value = "password") String password
    );

    @Modifying
    @Query("update User user set user.updatedAt = :updateAt where user.id = :id")
    public void updateAt(
            @Param(value = "id") Integer id,
            @Param(value = "updateAt")Instant updateAt
    );
}