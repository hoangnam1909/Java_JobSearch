package com.nhn.controllers;

import com.nhn.pojo.JobPost;
import com.nhn.pojo.User;
import com.nhn.service.JobPostService;
import com.nhn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminJobPost {

    @Autowired
    UserService userService;

    @Autowired
    JobPostService jobPostService;

    @RequestMapping("/admin/job-post")
    public String index(Model model) {
        List<JobPost> jobPosts = jobPostService.getPosts(null, 1);

        model.addAttribute("jobPosts", jobPosts);

        return "admin-job-post";
    }

    @RequestMapping("/admin/job-post/add")
    public String addJobPost(Model model) {
        List<User> users = userService.getUsers("");
        model.addAttribute("users", users);
        model.addAttribute("jobPost", new JobPost());

        return "add-job-post";
    }

    @PostMapping("/admin/job-post/add")
    @Transactional
    public String addJobPost(Model model, @ModelAttribute(value = "jobPost") JobPost jobPost) {
        String errMsg = null;

        model.addAttribute("title", jobPost.getTitle());
        model.addAttribute("description", jobPost.getDescription());
        model.addAttribute("postByUserId", jobPost.getPostedByUserId());

        //        this.jobPostService.addPost(jobPost);

        model.addAttribute("errMsg", errMsg);

        return "redirect:/admin/job-post";
    }
}
