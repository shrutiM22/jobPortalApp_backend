package com.portal.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.jobapplication.dao.JobApplicationDao;
import com.portal.jobapplication.dto.JobApplicationDto;
import com.portal.jobapplication.entity.JobApplication;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	JobApplicationDao jobapplicationdao;

	@Override
	public List<JobApplicationDto> ListOfUnapprovedJobApplication() {
		// creating a object of list job application and get all the list of job
		// application from database of job application
		List<JobApplication> list = jobapplicationdao.findAll();

		// Creating a new empty list of job application DTO
		List<JobApplicationDto> list2 = new ArrayList<>();

		// Iterating a list using for each loop
		for (JobApplication obj : list) {
			JobApplicationDto dto = new JobApplicationDto();
			// Condition for if job application not approved than we need to add in dto
			if (obj.getIsApprovedByAdmin() == false) {
				dto.setJobDescription(obj.getJobDescription());
				dto.setJobLocation(obj.getJobLocation());
				dto.setJobRole(obj.getJobRole());
				dto.setRequiredExperience(obj.getRequiredExperience());
				dto.setRequiredSkills(obj.getRequiredSkills());
				dto.setSalary(obj.getSalary());
				dto.setJobId(obj.getJobId());
				// we need to return a list that's why we add a dto in empty list2
				list2.add(dto);
			}

		}
		// returning a list2
		return list2;
	}
	//Method for approval
	@Override
	public void ApprovalByAdmin(int id) {
		//getting object from database of job application using id
		JobApplication approvalid = jobapplicationdao.getById(id);
		//Setting the boolean value true here
		approvalid.setIsApprovedByAdmin(true);
		//save it database of job application
		jobapplicationdao.save(approvalid);
	}

}
