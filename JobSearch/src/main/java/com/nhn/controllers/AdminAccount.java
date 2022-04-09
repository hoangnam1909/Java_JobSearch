/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhn.controllers;

import com.nhn.pojo.User;
import com.nhn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author Lightning
 */
@Controller
public class AdminAccount {

    @Autowired
    UserService userService;

    @RequestMapping("/admin/admin-account")
    public String index(Model model) {
        List<User> users = userService.getUsers("");
        model.addAttribute("users", users);

//        User firstUser = userService.getUserById(1);
//        model.addAttribute("firstUser", firstUser);

        return "admin-account";
    }
}
