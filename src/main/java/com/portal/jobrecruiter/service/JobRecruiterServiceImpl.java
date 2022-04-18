package com.portal.jobrecruiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.jobrecruiter.dto.JobRecruiterDto;
import com.portal.jobrecruiter.entity.JobRecruiter;
import com.portal.jobrecuiter.dao.JobRecuiterDao;
import com.portal.user.dao.UserDao;
import com.portal.user.entity.Users;

@Service
public class JobRecruiterServiceImpl implements JobRecruiterService {

	@Autowired
	JobRecuiterDao recruiterdao;

	@Override
	public JobRecruiterDto addJobRecruiter(JobRecruiter jobrecruiter) {
		//saving data into database and store in recruiter variable
		JobRecruiter recruiter = recruiterdao.save(jobrecruiter);
		
		//creating a object of jobrecruiterDto 
		JobRecruiterDto dto = new JobRecruiterDto();
		//getting a data from database and setting into dto which we create a new variable
		dto.setPhoneNumber(recruiter.getPhoneNumber());
		dto.setAboutMe(recruiter.getAboutMe());
		dto.setJobRecruiterId(recruiter.getJobRecruiterId());
		
		//return a dto 
		return dto;
	}

}
