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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
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

//        User firstUser = userService.getUserById(7);
//        model.addAttribute("firstUser", firstUser);

        return "admin-account";
    }

    @RequestMapping("/admin/admin-account/add-account")
    public String addAccount(Model model) {
        model.addAttribute("user", new User());
        return "add-account";
    }

    @PostMapping("/admin/admin-account/add-account")
    @Transactional
    public String addAccountPost(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";

        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("confirmPassword", user.getConfirmPassword());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("userType", user.getUserType());

        if (user.getPassword().equals(user.getConfirmPassword())) {
            errMsg = "Mat khau khop";
            this.userService.addUser(user);
            return "redirect:/admin/admin-account/add-account";
        } else
            errMsg = "Mat khau KHONG khop!";

        model.addAttribute("errMsg", errMsg);

        return "add-account";
    }

    @RequestMapping("/admin/admin-account/edit-account")
    public String editAccount(Model model) {
        model.addAttribute("user", new User());
        return "edit-account";
    }

//    @RequestMapping("/admin/admin-account/edit-account/{username}")
//    public String editAccountGet(Model model,
//                              @PathVariable(value = "username") String username) {
//        model.addAttribute("user", this.userService.getUsers(username));
////        model.addAttribute("user", new User());
//        model.addAttribute("id", username);
//        return "edit-account";
//    }

    @RequestMapping("/admin/admin-account/edit-account/{id}")
    public String editAccountGetById(Model model,
                                     @PathVariable(value = "id") int id) {
        User user = new User();
        if (id != 0) {
            user = this.userService.getUserById(id);
        }

        model.addAttribute("user", user);
        model.addAttribute("id", id);

        return "edit-account";
    }
}
