package com.mypkg.DataLayer;

import com.mypkg.Entity.User;

import java.util.Collection;

/**
 * Created by Ujjwal on 12/22/2016.
 */
public interface UserDao {
    Collection<User> getAllUsers();

    User getUserById(int id);

    void removeUserById(int id);

    void updateUser(User user);

    void insertUserToDb(User user);
}