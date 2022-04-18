package com.nhn.service.impl;

import com.nhn.pojo.JobPost;
import com.nhn.repository.JobPostRepository;
import com.nhn.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JobPostServiceImpl implements JobPostService {

    @Autowired
    JobPostRepository jobPostRepository;

    @Override
    public JobPost getPostById(int id) {
        return this.jobPostRepository.getPostById(id);
    }

    @Override
    public Boolean addPost(JobPost post) {
        return this.jobPostRepository.addPost(post);
    }

    @Override
    public List<JobPost> getPosts(Map<String, String> params, int page) {
        return this.jobPostRepository.getPosts(params, page);
    }

    @Override
    public boolean deletePost(JobPost post) {
        return this.jobPostRepository.deletePost(post);
    }

    @Override
    public boolean updatePost(JobPost post) {
        return this.jobPostRepository.updatePost(post);
    }
}

