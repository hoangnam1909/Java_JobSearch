/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhn.service;

import com.nhn.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 *
 * @author Lightning
 */
public interface UserService extends UserDetailsService {

    User getUserById(int userId);
    boolean addUser(User user);
    List<User> getUsers(String username);

}
