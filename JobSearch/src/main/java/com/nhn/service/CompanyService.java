package com.nhn.service;

import com.nhn.pojo.Company;

import java.util.List;
import java.util.Map;

public interface CompanyService {

    Company getCompanyById(int id);
    boolean addCompany(Company company);
    List<Company> getCompanies(Map<String, String> params, int page);
    boolean deleteCompany(Company company);
    boolean updateCompany(Company company);

}
