/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhn.repository;

import com.nhn.pojo.User;
import java.util.List;

/**
 *
 * @author Lightning
 */
public interface UserRepository {

    User getUserById(int userId);

    boolean addUser(User user);

    boolean removeUser(User user);

    List<User> getUsers(String username);

    List<User> getAllUsers();
}
