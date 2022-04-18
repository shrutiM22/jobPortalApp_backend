package com.portal.jobseeker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.jobapplication.dao.JobApplicationDao;
import com.portal.jobapplication.dto.JobApplicationDto;
import com.portal.jobapplication.entity.JobApplication;
import com.portal.jobseeker.dao.JobSeekerDao;
import com.portal.jobseeker.dto.JobSeekerDto;
import com.portal.jobseeker.entity.JobSeeker;
import com.portal.user.dao.UserDao;
import com.portal.user.entity.Users;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {
	@Autowired
	JobSeekerDao dao;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	JobApplicationDao jobapplicationdao;
	
	@Override
	public JobSeekerDto addJobSeeker(JobSeeker jobseeker) {
		
		//creating a new object of dto
		JobSeekerDto dto = new JobSeekerDto();
		
		//saving a data into database of job seeker usinf save method
		JobSeeker seeker =  dao.save(jobseeker);
		//Using users database getting a user id which is in seeker where user id is available
		Users users = userdao.getById(seeker.getUsers().getUserId());
		
		//Here we are setting all details of user which is now work as a seeker 
		seeker.setUsers(users);
		
		//setting all the attributes in dto and getting data from  database of jobseeker
		dto.setPhoneNumber(seeker.getPhoneNumber());
		dto.setAboutMe(seeker.getAboutMe());
		dto.setExperience(seeker.getExperience());
		dto.setProject(seeker.getProject());
		dto.setSkills(seeker.getSkills());
		dto.setJobseekerId(seeker.getJobSeekerId());
		dto.setUser(seeker.getUsers());
		
		return dto;
	}
	
	
	
	//This methos is for updation of jobseeker details
	public JobSeekerDto updateJobSeeker(JobSeeker jobseeker,int id ) {
		//getting object of jobseeker using jobseeker id
		JobSeeker seeker = dao.getById(id);
		
		seeker.setJobseekerId(jobseeker.getJobseekerId());
		seeker.setPhoneNumber(jobseeker.getPhoneNumber());
		seeker.setAboutMe(jobseeker.getAboutMe());
		seeker.setExperience(jobseeker.getExperience());
		seeker.setProject(jobseeker.getProject());
		seeker.setSkills(jobseeker.getSkills());
		
		//saving a data in database
		JobSeeker seeker1 = dao.save(jobseeker);
		//creating a dto of jobseekerdto
		JobSeekerDto dto = new JobSeekerDto();
		
		//Here stting a new updated data and getting from database which is in jobseeker1
		
		dto.setAboutMe(seeker1.getAboutMe());
		dto.setExperience(seeker1.getExperience());
		dto.setJobseekerId(seeker1.getJobSeekerId());
		dto.setPhoneNumber(seeker1.getPhoneNumber());
		dto.setProject(seeker1.getProject());
		dto.setSkills(seeker1.getSkills());
		dto.setUser(seeker1.getUsers());
		
		return dto;
		}
	//method of list of approved job application
	@Override
	public List<JobApplicationDto> ListOfApprovedJobApplication() {
		
		List<JobApplication> list = jobapplicationdao.findAll();
		
		//craeting a new empty list
		List<JobApplicationDto> list2 = new ArrayList<>();
		
		
		
		//Iterating job application using for each loop
		for(JobApplication obj : list)
		{
			JobApplicationDto dto = new JobApplicationDto();
			//here condtion for checking approval
			if(obj.getIsApprovedByAdmin()==true)
			{
				dto.setJobDescription(obj.getJobDescription());
				dto.setJobLocation(obj.getJobLocation());
				dto.setJobRole(obj.getJobRole());
				dto.setRequiredExperience(obj.getRequiredExperience());
				dto.setRequiredSkills(obj.getRequiredSkills());
				dto.setSalary(obj.getSalary());
				dto.setJobId(obj.getJobId());
				
				//Here we adding dto into list beacuse our return type is list
				list2.add(dto);
			}
			
		}
		return list2;
	}

	

}
