package com.portal.jobseeker.service;

import java.util.List;

import com.portal.jobapplication.dto.JobApplicationDto;
import com.portal.jobseeker.dto.JobSeekerDto;
import com.portal.jobseeker.entity.JobSeeker;

public interface JobSeekerService {
	
	JobSeekerDto addJobSeeker(JobSeeker job);
	
	//JobSeekerDto updateJobSeeker1(JobSeeker job,int id);

	JobSeekerDto updateJobSeeker(JobSeeker job, int id);
	
	List<JobApplicationDto> ListOfApprovedJobApplication();

}
