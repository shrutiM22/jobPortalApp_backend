package com.portal.jobapplication.dto;

import java.util.Set;

import com.portal.jobrecruiter.entity.JobRecruiter;
import com.portal.jobseeker.entity.JobSeeker;

public class JobApplicationDto {

	private int jobId;

	private String jobDescription;

	private int requiredExperience;

	private String requiredSkills;

	private int salary;

	private String jobLocation;

	private String JobRole;

	private JobRecruiter jobrecruiter;
	
	private Set<JobSeeker> jobSeekersApplied;
	
	private Boolean isApprovedByAdmin;

	public Boolean getIsApprovedByAdmin() {
		return isApprovedByAdmin;
	}

	public void setIsApprovedByAdmin(Boolean isApprovedByAdmin) {
		this.isApprovedByAdmin = isApprovedByAdmin;
	}

	public int getJobId() {
		return jobId;
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

	
	

}
