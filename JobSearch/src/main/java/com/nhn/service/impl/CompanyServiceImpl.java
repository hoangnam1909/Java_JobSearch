package com.nhn.service.impl;

import com.nhn.pojo.Company;
import com.nhn.repository.CompanyRepository;
import com.nhn.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company getCompanyById(int id) {
        return this.companyRepository.getCompanyById(id);
    }

    @Override
    public boolean addCompany(Company company) {
        return this.companyRepository.addCompany(company);
    }

    @Override
    public List<Company> getCompanies(Map<String, String> params, int page) {
        return this.companyRepository.getCompanies(params, page);
    }

    @Override
    public boolean deleteCompany(Company company) {
        return this.companyRepository.deleteCompany(company);
    }

    @Override
    public boolean updateCompany(Company company) {
        return this.companyRepository.updateCompany(company);
    }
}
