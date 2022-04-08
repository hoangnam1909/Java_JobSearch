/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhn.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Lightning
 */
@Entity
@Table(name = "job_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobLocation.findAll", query = "SELECT j FROM JobLocation j"),
    @NamedQuery(name = "JobLocation.findById", query = "SELECT j FROM JobLocation j WHERE j.id = :id"),
    @NamedQuery(name = "JobLocation.findByStreetAddress", query = "SELECT j FROM JobLocation j WHERE j.streetAddress = :streetAddress"),
    @NamedQuery(name = "JobLocation.findByDistrict", query = "SELECT j FROM JobLocation j WHERE j.district = :district"),
    @NamedQuery(name = "JobLocation.findByCity", query = "SELECT j FROM JobLocation j WHERE j.city = :city"),
    @NamedQuery(name = "JobLocation.findByCountry", query = "SELECT j FROM JobLocation j WHERE j.country = :country"),
    @NamedQuery(name = "JobLocation.findByZip", query = "SELECT j FROM JobLocation j WHERE j.zip = :zip")})
public class JobLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "street_address")
    private String streetAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "district")
    private String district;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "zip")
    private String zip;
    @OneToMany(mappedBy = "jobLocationId")
    private Collection<JobPost> jobPostCollection;

    public JobLocation() {
    }

    public JobLocation(Integer id) {
        this.id = id;
    }

    public JobLocation(Integer id, String streetAddress, String district, String city, String country, String zip) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.district = district;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @XmlTransient
    public Collection<JobPost> getJobPostCollection() {
        return jobPostCollection;
    }

    public void setJobPostCollection(Collection<JobPost> jobPostCollection) {
        this.jobPostCollection = jobPostCollection;
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
        if (!(object instanceof JobLocation)) {
            return false;
        }
        JobLocation other = (JobLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhn.pojo.JobLocation[ id=" + id + " ]";
    }
    
}
