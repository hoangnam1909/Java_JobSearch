/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhn.service;

import com.nhn.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Lightning
 */
public interface UserService extends UserDetailsService {
    User getUserById(int id);
    List<User> getAllUsers();
}
