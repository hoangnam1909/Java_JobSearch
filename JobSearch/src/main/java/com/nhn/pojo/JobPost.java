/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhn.pojo;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Lightning
 */
@Entity
@Table(name = "job_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobPost.findAll", query = "SELECT j FROM JobPost j"),
    @NamedQuery(name = "JobPost.findById", query = "SELECT j FROM JobPost j WHERE j.id = :id"),
    @NamedQuery(name = "JobPost.findByCreatedDate", query = "SELECT j FROM JobPost j WHERE j.createdDate = :createdDate"),
    @NamedQuery(name = "JobPost.findByUpdatedDate", query = "SELECT j FROM JobPost j WHERE j.updatedDate = :updatedDate"),
    @NamedQuery(name = "JobPost.findByJobTitle", query = "SELECT j FROM JobPost j WHERE j.jobTitle = :jobTitle"),
    @NamedQuery(name = "JobPost.findByActive", query = "SELECT j FROM JobPost j WHERE j.active = :active")})
public class JobPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @Size(max = 100)
    @Column(name = "job_title")
    private String jobTitle;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company companyId;
    @JoinColumn(name = "job_location_id", referencedColumnName = "id")
    @ManyToOne
    private JobLocation jobLocationId;
    @JoinColumn(name = "job_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JobType jobTypeId;
    @JoinColumn(name = "posted_by_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User postedByUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobPostId")
    private Collection<JobPostSkill> jobPostSkillCollection;

    public JobPost() {
    }

    public JobPost(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public JobLocation getJobLocationId() {
        return jobLocationId;
    }

    public void setJobLocationId(JobLocation jobLocationId) {
        this.jobLocationId = jobLocationId;
    }

    public JobType getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(JobType jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public User getPostedByUser() {
        return postedByUser;
    }

    public void setPostedByUser(User postedByUser) {
        this.postedByUser = postedByUser;
    }

    @XmlTransient
    public Collection<JobPostSkill> getJobPostSkillCollection() {
        return jobPostSkillCollection;
    }

    public void setJobPostSkillCollection(Collection<JobPostSkill> jobPostSkillCollection) {
        this.jobPostSkillCollection = jobPostSkillCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobPost)) {
            return false;
        }
        JobPost other = (JobPost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhn.pojo.JobPost[ id=" + id + " ]";
    }
    
}
