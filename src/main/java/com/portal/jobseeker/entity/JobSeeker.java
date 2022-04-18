package com.portal.jobseeker.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.portal.jobapplication.entity.JobApplication;
import com.portal.user.entity.Users;

@Entity
public class JobSeeker {
	@Id
	@SequenceGenerator(name = "job_seeker_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_seeker_sequence")
	@Column(name = "job_seeker_id")
	private int jobseekerId;

	private String phoneNumber;

	private int experience;

	private String skills;

	private String project;

	private String aboutMe;
	
	@ManyToMany(mappedBy = "jobSeekersApplied")
	private Set<JobApplication> jobapplication = new HashSet<>();
	
	//any user can be a job seeker using foreign key
	@OneToOne
	private Users users;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getJobseekerId() {
		return jobseekerId;
	}

	public void setJobseekerId(int jobseekerId) {
		this.jobseekerId = jobseekerId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public JobSeeker() {
		// TODO Auto-generated constructor stub
	}

	public JobSeeker(String phoneNumber, int experience, String skills, String project, String aboutMe,
			Users users) {
		super();
		this.phoneNumber = phoneNumber;
		this.experience = experience;
		this.skills = skills;
		this.project = project;
		this.aboutMe = aboutMe;
		this.users = users;
	}

	public int getJobSeekerId() {
		// TODO Auto-generated method stub
		return jobseekerId;
	}

	
}
