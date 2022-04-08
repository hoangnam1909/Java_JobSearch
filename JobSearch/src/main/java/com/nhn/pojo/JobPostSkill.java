/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhn.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Lightning
 */
@Entity
@Table(name = "job_post_skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobPostSkill.findAll", query = "SELECT j FROM JobPostSkill j"),
    @NamedQuery(name = "JobPostSkill.findById", query = "SELECT j FROM JobPostSkill j WHERE j.id = :id")})
public class JobPostSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "job_post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private JobPost jobPostId;
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Skill skillId;

    public JobPostSkill() {
    }

    public JobPostSkill(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobPost getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(JobPost jobPostId) {
        this.jobPostId = jobPostId;
    }

    public Skill getSkillId() {
        return skillId;
    }

    public void setSkillId(Skill skillId) {
        this.skillId = skillId;
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
        if (!(object instanceof JobPostSkill)) {
            return false;
        }
        JobPostSkill other = (JobPostSkill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhn.pojo.JobPostSkill[ id=" + id + " ]";
    }
    
}
