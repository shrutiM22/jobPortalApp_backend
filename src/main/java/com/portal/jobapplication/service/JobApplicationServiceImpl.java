package com.portal.jobapplication.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.jobapplication.dao.JobApplicationDao;
import com.portal.jobapplication.dto.JobApplicationDto;
import com.portal.jobapplication.entity.JobApplication;
import com.portal.jobrecruiter.entity.JobRecruiter;
import com.portal.jobrecuiter.dao.JobRecuiterDao;
import com.portal.jobseeker.dao.JobSeekerDao;
import com.portal.jobseeker.entity.JobSeeker;

@Service
public class JobApplicationServiceImpl {

	@Autowired
	JobApplicationDao jobdao;

	@Autowired
	JobRecuiterDao recruiterdao;

	@Autowired
	JobSeekerDao seekerdao;

	public JobApplicationDto addJobApplication(JobApplication jobapplication)

	{
		//By default we are setting a approval for all job application as false (Bydefault)
		jobapplication.setIsApprovedByAdmin(false);
		
		//Saving data in database and store in job variable which is object type(job application)
		JobApplication job = jobdao.save(jobapplication);
		
		//creating a object of job application dto
		JobApplicationDto dto = new JobApplicationDto();
		
		//Here getting data from database and setting a data in dto which we return
		dto.setJobId(job.getJobId());
		dto.setJobDescription(job.getJobDescription());
		dto.setRequiredExperience(job.getRequiredExperience());
		dto.setRequiredSkills(job.getRequiredSkills());
		dto.setSalary(job.getSalary());
		dto.setJobLocation(job.getJobLocation());
		dto.setJobRole(job.getJobRole());
		
		//Here we getting a id of job recruiter and store in variable 
		int recruiterid =jobapplication.getJobrecruiter().getJobRecruiterId();
		
		//By using recruiter id getting a object of recruiter and store in new variable object which is job recruiter type 
		JobRecruiter jobrecruiter = recruiterdao.getById(recruiterid); //.getJobrecruiter()
		jobrecruiter.setJobApplication(null);
		jobrecruiter.setUsers(null);
		
//		JobRecruiter jobrecruiter1 = new JobRecruiter();
//		
//		jobrecruiter1.setJobRecruiterId(jobrecruiter.getJobRecruiterId());
//		jobrecruiter1.setAboutMe(jobrecruiter.getAboutMe());
//		jobrecruiter1.setPhoneNumber(jobrecruiter.getPhoneNumber());
		
		//setting a job recruiter in dto
		dto.setJobrecruiter(jobrecruiter);

		//creating a new set of job seeker 
		Set<JobSeeker> seekerset = new HashSet<>();
		//Iterating job seeker using for each loop
		for (JobSeeker obj : jobapplication.getJobSeekersApplied()) {
			//getting id from obj which we iterate and store in new variable which is int type 
			int seekerid = obj.getJobSeekerId();
			//Here we get the object using getById
			JobSeeker jobseeker = seekerdao.getById(seekerid);
			//adding all the job seeker in set using add method
			seekerset.add(jobseeker);
		}
		//here that set of job seeker set into dto
		dto.setJobSeekersApplied(seekerset);
		
		dto.setIsApprovedByAdmin(job.getIsApprovedByAdmin());

		
		return dto;
	}

}
