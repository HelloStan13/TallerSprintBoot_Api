package com.megawarez.service.interfaces;

import com.megawarez.domain.Session;
import com.megawarez.domain.User;

import java.util.List;

public interface IUser {

    public List<User> getList();

    public User createUser(User user);

    User updateUser(Integer id ,User user);

    User updateUsername(Integer id, User user);

    User updatePassword(Integer id, User user);

    Session logIn(User user);

    Session signOut();


}
