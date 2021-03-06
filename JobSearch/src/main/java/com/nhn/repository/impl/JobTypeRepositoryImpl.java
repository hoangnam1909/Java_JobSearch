package com.nhn.repository.impl;

import com.nhn.pojo.JobType;
import com.nhn.repository.JobTypeRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class JobTypeRepositoryImpl implements JobTypeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public JobType getJobTypeById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(JobType.class, id);
    }

    @Override
    public Boolean addJobType(JobType jobType) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(jobType);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public List<JobType> getJobTypes(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<JobType> query = builder.createQuery(JobType.class);
        Root root = query.from(JobType.class);
        query = query.select(root);

        if (!name.isEmpty()) {
            Predicate p = builder.equal(root.get("name").as(String.class), name.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean deleteJobType(JobType jobType) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(jobType);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateJobType(JobType jobType) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(jobType);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }
}
