/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki*           <br/>
 *\*           andrzej.piechocki@software.com *
 *  Created: 2023-12-10
 *
 *****************************************************/
package com.software.domain.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.software.domain.BaseEntity;
import com.software.domain.lookup.PersonalTitleEnum;
import com.software.domain.lookup.converter.PersonalTitleEnumConverter;
import com.software.domain.region.Country;
import com.software.domain.region.DutyStation;

@Entity
@Table(name = "USER_PROFILE")
public class UserProfile extends BaseEntity {

    @Temporal(TemporalType.DATE)
    @Column(name = "DOB")
    protected Date dob;

    @Column(name = "FIRST_NAME", nullable = false, length = 64)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 64)
    private String lastName;

    @Column(name= "PERSONAL_TITLE_ID")
    @Convert(converter = PersonalTitleEnumConverter.class)
    private PersonalTitleEnum personalTitle;

    @Column(name = "EMAIL", nullable = false, length = 128)
    private String email;

    @ManyToMany(mappedBy = "userProfiles", fetch = FetchType.LAZY)
    private Set<Role> roles;

    @Column(name = "SALT", nullable = true)
    private Long salt;

    @Column(name = "PASSWORD", length = 128, nullable = false)
    private String password;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active;

    @Column(name = "FAILED_ATTEMPTS", nullable = true)
    private Integer failedAttempts;

    @Column(name = "LAST_ATTEMPT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAttemptDate;

    @Column(name = "USAGE_AGREEMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usageAgreementDate;

    @Column(name = "TOKEN", unique=true, length = 70)
    private String token;

    @Column(name = "IS_CONSULTANT", nullable = false)
    private Boolean consultant;

    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "JOB_TITLE")
    private String jobTitle;
    
    @Column(name = "MESSAGE_LANGUAGE", unique=true, length = 3)
    private String message_language;

    @Column(name = "ACADEMIC_TITLE")
    private String academicTitle;

    @Column(name = "RESIDENCE_LOCATION")
    private String residenceLocation;

    @Column(name = "CONTRACT_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date contractEndDate;

    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne
    private Country country;

    @JoinColumn(name = "duty_station_id", referencedColumnName = "id")
    @ManyToOne
    private DutyStation dutyStation;

    @JoinColumn(name = "user_image_id", referencedColumnName = "id")
    @ManyToOne
    private UserImage userImage;

    @JoinColumn(name = "updated_by_id", referencedColumnName = "id")
    @ManyToOne
    private UserProfile updatedBy;

    @Column(name = "RESET_PASSWORD_VALID_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resetPasswordValidDate;

    public UserProfile() {
    }

    public UserProfile(final String firstNameArg, final String lastNameArg, final String emailArg, final String tokenArg,final String languageArg) {
        this.firstName = firstNameArg;
        this.lastName = lastNameArg;
        this.email = emailArg;
        this.token = tokenArg;
        this.message_language = languageArg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String tokenArg) {
        this.token = tokenArg;
    }

    public String getLanguageMessage() {
        return message_language;
    }

    public void getLanguageMessage(final String languageArg) {
        this.message_language = languageArg;
    }
    
    public Date getDob() {
        return this.dob;
    }

    public String getEmail() {
        return this.email;
    }

    public Date getResetPasswordValidDate() {
        return resetPasswordValidDate;
    }

    public void setResetPasswordValidDate(final Date resetPasswordValidDate) {
        this.resetPasswordValidDate = resetPasswordValidDate;
    }

    public Integer getFailedAttempts() {
        return this.failedAttempts;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(final Date updateDate) {
        this.updateDate = updateDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(final String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(final String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public String getResidenceLocation() {
        return residenceLocation;
    }

    public void setResidenceLocation(final String residenceLocation) {
        this.residenceLocation = residenceLocation;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(final Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public DutyStation getDutyStation() {
        return dutyStation;
    }

    public void setDutyStation(final DutyStation dutyStation) {
        this.dutyStation = dutyStation;
    }

    public UserImage getUserImage() {
        return userImage;
    }

    public void setUserImage(final UserImage userImage) {
        this.userImage = userImage;
    }

    public UserProfile getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final UserProfile updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Boolean getConsultant() {
        return consultant;
    }

    public void setConsultant(final Boolean consultant) {
        this.consultant = consultant;
    }

    public Date getLastAttemptDate() {
        return this.lastAttemptDate;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public Long getSalt() {
        return this.salt;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(final boolean activeArg) {
        this.active = activeArg;
    }

    public void setDob(final Date dobArg) {
        this.dob = dobArg;
    }

    public void setEmail(final String emailArg) {
        //method for finding user based on lowerCase so email should be stored in db in this way
        this.email = emailArg!=null? emailArg.toLowerCase():null;
    }

    public PersonalTitleEnum getPersonalTitle() {
        return personalTitle;
    }

    public void setPersonalTitle(final PersonalTitleEnum personalTitle) {
        this.personalTitle = personalTitle;
    }

    public void setFailedAttempts(final Integer failedAttemptsArg) {
        this.failedAttempts = failedAttemptsArg;
    }

    public Date getUsageAgreementDate() {
        return usageAgreementDate;
    }

    public void setUsageAgreementDate(final Date usageAgreementDateArg) {
        this.usageAgreementDate = usageAgreementDateArg;
    }

    public void setFirstName(final String firstNameArg) {
        this.firstName = firstNameArg;
    }

    public void setLastAttemptDate(final Date lastAttemptDateArg) {
        this.lastAttemptDate = lastAttemptDateArg;
    }

    public void setLastName(final String lastNameArg) {
        this.lastName = lastNameArg;
    }

    public void setPassword(final String passwordArg) {
        this.password = passwordArg;
    }

    public void setRoles(final Set<Role> rolesArg) {
        this.roles = rolesArg;
    }

    public void setSalt(final Long saltArg) {
        this.salt = saltArg;
    }
}
