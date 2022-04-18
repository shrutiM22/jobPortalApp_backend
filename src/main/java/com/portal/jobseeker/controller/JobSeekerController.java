package com.portal.jobseeker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.jobapplication.dto.JobApplicationDto;
import com.portal.jobapplication.entity.JobApplication;
import com.portal.jobseeker.dto.JobSeekerDto;
import com.portal.jobseeker.entity.JobSeeker;
import com.portal.jobseeker.service.JobSeekerService;

@Controller
//@RequestMapping("/jobseeker")
public class JobSeekerController {
	@Autowired
	JobSeekerService service;
	
	@CrossOrigin(origins = "http://localhost:3001")
	@RequestMapping(value = "/addjobS", method = { RequestMethod.GET, RequestMethod.POST })
	public JobSeekerDto addJobSeeker(@RequestBody JobSeeker job) {
		 return service.addJobSeeker(job);
		//return "jobSeeker.jsp";
		}
	
	
	@CrossOrigin(origins = "http://localhost:3001")
	@RequestMapping(value = "/updatejobS", method = { RequestMethod.PUT, RequestMethod.POST })
	public JobSeekerDto updateJobSeeker(@RequestBody JobSeeker job , @PathVariable Integer id) {
		//System.out.println(id);
		
		return service.updateJobSeeker(job,id);
	}

}

