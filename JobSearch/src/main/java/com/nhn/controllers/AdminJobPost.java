package com.nhn.controllers;

import com.nhn.pojo.JobPost;
import com.nhn.pojo.User;
import com.nhn.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminJobPost {

    @Autowired
    JobPostService jobPostService;

    @RequestMapping("/admin/job-post")
    public String index(Model model) {
        List<JobPost> jobPosts = jobPostService.getPosts(null, 1);

        model.addAttribute("jobPosts", jobPosts);

        return "admin-job-post";
    }
}
