package com.portal.admin.service;

import java.util.List;

import com.portal.jobapplication.dto.JobApplicationDto;

public interface AdminService  {
	//Creating method which we want in admin 
	List<JobApplicationDto> ListOfUnapprovedJobApplication();
	
	void ApprovalByAdmin(int id);

}
