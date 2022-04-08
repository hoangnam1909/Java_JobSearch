package com.nhn.controllers;

import com.nhn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddAccount {

    @RequestMapping("/admin/admin-account/add-account")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "add-account";
    }

    @PostMapping("/admin/admin-account/add-account")
    public String addAccountPost(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";

        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("confirmPassword", user.getConfirmPassword());

        if (user.getPassword().equals(user.getConfirmPassword())) {
            errMsg = "Mat khau khop";
        } else
            errMsg = "Mat khau KHONG khop!";

        model.addAttribute("errMsg", errMsg);

        return "add-account";
    }

}
