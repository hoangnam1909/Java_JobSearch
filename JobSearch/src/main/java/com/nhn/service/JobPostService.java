package com.nhn.service;

import com.nhn.pojo.JobPost;

import java.util.List;
import java.util.Map;

public interface JobPostService {

    JobPost getPostById(int id);
    Boolean addPost(JobPost post);
    List<JobPost> getPosts(Map<String, String> param, int page);
    boolean deletePost(JobPost post);
    boolean updatePost(JobPost post);

}
