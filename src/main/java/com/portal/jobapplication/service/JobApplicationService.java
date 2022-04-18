package com.portal.jobapplication.service;

import com.portal.jobapplication.dto.JobApplicationDto;
import com.portal.jobapplication.entity.JobApplication;

public interface JobApplicationService {
	
	JobApplicationDto addJobApplication(JobApplication jobapplication);

}
