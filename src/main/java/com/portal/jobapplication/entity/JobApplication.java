package com.portal.jobapplication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.portal.jobrecruiter.entity.JobRecruiter;
import com.portal.jobseeker.entity.JobSeeker;

@Entity
public class JobApplication {
	@Id
	@SequenceGenerator(name = "job_application_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_application_sequence")
	@Column(name = "job_id")
	private int jobId;
	
	private String jobDescription;
	
	private int requiredExperience;
	
	private String requiredSkills;
	
	private int salary;
	
	private String jobLocation;
	
	private String JobRole;
	
	@Column(name="is_approved_by_admin")
	private Boolean isApprovedByAdmin;
	
	public Boolean getIsApprovedByAdmin() {
		return isApprovedByAdmin;
	}

	public void setIsApprovedByAdmin(Boolean isApprovedByAdmin) {
		this.isApprovedByAdmin = isApprovedByAdmin;
	}

	@ManyToOne
	@JoinColumn(name = "job_recruiter_id", updatable = false)
	private JobRecruiter jobrecruiter;
	
	@ManyToMany
	@JoinTable(	name = "job_seeker_join_job_application",
				joinColumns = @JoinColumn(name = " job_id"),
				inverseJoinColumns = @JoinColumn (name = "job_seeker_id")
			
			)
	private Set<JobSeeker> jobSeekersApplied = new HashSet<>();

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public int getRequiredExperience() {
		return requiredExperience;
	}

	public void setRequiredExperience(int requiredExperience) {
		this.requiredExperience = requiredExperience;
	}

	public String getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getJobRole() {
		return JobRole;
	}

	public void setJobRole(String jobRole) {
		JobRole = jobRole;
	}

	public JobRecruiter getJobrecruiter() {
		return jobrecruiter;
	}

	public void setJobrecruiter(JobRecruiter jobrecruiter) {
		this.jobrecruiter = jobrecruiter;
	}
	
	
	public Set<JobSeeker> getJobSeekersApplied() {
		return jobSeekersApplied;
	}

	public void setJobSeekersApplied(Set<JobSeeker> jobSeekersApplied) {
		this.jobSeekersApplied = jobSeekersApplied;
	}

	public JobApplication() {
		// TODO Auto-generated constructor stub
	}
	
	

}
