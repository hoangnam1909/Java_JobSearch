/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhn.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lightning
 */
@Entity
@Table(name = "personal_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalDetails.findAll", query = "SELECT p FROM PersonalDetails p"),
    @NamedQuery(name = "PersonalDetails.findById", query = "SELECT p FROM PersonalDetails p WHERE p.id = :id"),
    @NamedQuery(name = "PersonalDetails.findByFirstName", query = "SELECT p FROM PersonalDetails p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "PersonalDetails.findByLastName", query = "SELECT p FROM PersonalDetails p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "PersonalDetails.findByGender", query = "SELECT p FROM PersonalDetails p WHERE p.gender = :gender"),
    @NamedQuery(name = "PersonalDetails.findByDob", query = "SELECT p FROM PersonalDetails p WHERE p.dob = :dob"),
    @NamedQuery(name = "PersonalDetails.findByNationality", query = "SELECT p FROM PersonalDetails p WHERE p.nationality = :nationality"),
    @NamedQuery(name = "PersonalDetails.findByPhone", query = "SELECT p FROM PersonalDetails p WHERE p.phone = :phone")})
public class PersonalDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private boolean gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nationality")
    private String nationality;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "phone")
    private String phone;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;

    public PersonalDetails() {
    }

    public PersonalDetails(Integer id) {
        this.id = id;
    }

    public PersonalDetails(Integer id, String firstName, String lastName, boolean gender, Date dob, String nationality, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.nationality = nationality;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof PersonalDetails)) {
            return false;
        }
        PersonalDetails other = (PersonalDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhn.pojo.PersonalDetails[ id=" + id + " ]";
    }
    
}
