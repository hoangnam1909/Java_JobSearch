package com.nhn.service.impl;

import com.nhn.pojo.JobType;
import com.nhn.repository.JobTypeRepository;
import com.nhn.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTypeServiceImpl implements JobTypeService {

    @Autowired
    JobTypeRepository jobTypeRepository;

    @Override
    public JobType getJobTypeById(int id) {
        return this.jobTypeRepository.getJobTypeById(id);
    }

    @Override
    public Boolean addJobType(JobType jobType) {
        return this.jobTypeRepository.addJobType(jobType);
    }

    @Override
    public List<JobType> getJobTypes(String name) {
        return this.jobTypeRepository.getJobTypes(name);
    }

    @Override
    public boolean deleteJobType(JobType jobType) {
        return this.jobTypeRepository.deleteJobType(jobType);
    }

    @Override
    public boolean updateJobType(JobType jobType) {
        return this.jobTypeRepository.updateJobType(jobType);
    }
}
