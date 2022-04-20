package com.nhn.repository.impl;

import com.nhn.pojo.Company;
import com.nhn.repository.CompanyRepository;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Company getCompanyById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Company.class, id);
    }

    @Override
    public boolean addCompany(Company company) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(company);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public List<Company> getCompanies(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Company> q = builder.createQuery(Company.class);
        Root root = q.from(Company.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            if (params.containsKey("name")) {
                Predicate p1 = builder.like(root.get("name").as(String.class),
                        String.format("%%%s%%", params.get("name")));
                predicates.add(p1);
            }

            if (params.containsKey("contact")) {
                Predicate p2 = builder.like(root.get("contact").as(String.class),
                        String.format("%%%s%%", params.get("contact")));
                predicates.add(p2);
            }

            if (params.containsKey("email")) {
                Predicate p3 = builder.like(root.get("email").as(String.class),
                        String.format("%%%s%%", params.get("email")));
                predicates.add(p3);
            }

            if (params.containsKey("location")) {
                Predicate p4 = builder.like(root.get("location").as(String.class),
                        String.format("%%%s%%", params.get("location")));
                predicates.add(p4);
            }

            if (params.containsKey("website")) {
                Predicate p5 = builder.like(root.get("website").as(String.class),
                        String.format("%%%s%%", params.get("website")));
                predicates.add(p5);
            }

            q = q.where(predicates.toArray(new Predicate[]{}));
        }

        q = q.orderBy(builder.desc(root.get("id")));

        Query query = session.createQuery(q);

        if (page != 0) {
            int max = 10;
            int index = (page - 1) * max;
            query.setFirstResult(index);
            query.setMaxResults(3);
        }

        return query.getResultList();
    }

    @Override
    public boolean deleteCompany(Company company) {
        return false;
    }

    @Override
    public boolean updateCompany(Company company) {
        return false;
    }

}
