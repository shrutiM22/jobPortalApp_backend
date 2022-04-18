package com.portal.jobapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.jobapplication.dto.JobApplicationDto;
import com.portal.jobapplication.entity.JobApplication;
import com.portal.jobapplication.service.JobApplicationServiceImpl;

@Controller
//@RequestMapping("/jobapplication")
public class JobApplicationController {
		@Autowired
		JobApplicationServiceImpl jobservice;
		
		
		@CrossOrigin(origins = "http://localhost:3001")
		@RequestMapping(value = "/jobApplication", method = { RequestMethod.GET, RequestMethod.POST })
		public JobApplicationDto getAppl(@RequestBody JobApplication jobapplication) {
			 return jobservice.addJobApplication(jobapplication);
	}
}
