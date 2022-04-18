package com.nhn.repository;

import com.nhn.pojo.JobPost;

import java.util.List;
import java.util.Map;

public interface JobPostRepository {

    JobPost getPostById(int id);
    Boolean addPost(JobPost post);
    List<JobPost> getPosts(Map<String, String> params, int page);
    boolean deletePost(JobPost post);
    boolean updatePost(JobPost post);

}
