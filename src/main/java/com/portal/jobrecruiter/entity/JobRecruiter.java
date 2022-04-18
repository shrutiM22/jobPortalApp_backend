package com.portal.jobrecruiter.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.portal.jobapplication.entity.JobApplication;
import com.portal.user.entity.Users;

@Entity
public class JobRecruiter {
	@Id
	@SequenceGenerator(name = "job_recruiter_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_recruiter_sequence")
	@Column(name = "job_recruiter_id")
	private int jobRecruiterId;
	 
	private String phoneNumber;
	
	private String aboutMe;
	
	@OneToMany
	@JoinColumn(name = "job_recruiter_id")
	private Set<JobApplication> jobApplication = new HashSet<>();  //used set instead of list
	
	
	@OneToOne
	private Users users;  //every recruiter is finally a user (foreign key)
		
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Set<JobApplication> getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(Set<JobApplication> jobApplication) {
		this.jobApplication = jobApplication;
	}

	public int getJobRecruiterId() {
		return jobRecruiterId;
	}

	public void setJobRecruiterId(int jobRecruiterId) {
		this.jobRecruiterId = jobRecruiterId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
	public JobRecruiter() {
		// TODO Auto-generated constructor stub
	}

}
