package com.nhn.service;

import com.nhn.pojo.JobType;

import java.util.List;

public interface JobTypeService {

    JobType getJobTypeById(int id);
    Boolean addJobType(JobType jobType);
    List<JobType> getJobTypes(String name);
    boolean deleteJobType(JobType jobType);
    boolean updateJobType(JobType jobType);

}
