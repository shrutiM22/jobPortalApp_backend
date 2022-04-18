package com.portal.jobrecruiter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.jobrecruiter.dto.JobRecruiterDto;
import com.portal.jobrecruiter.entity.JobRecruiter;
import com.portal.jobrecruiter.service.JobRecruiterServiceImpl;

@Controller
//@RequestMapping("/jobrecruiter")
public class JobRecruiterController {
	@Autowired
	JobRecruiterServiceImpl recruiterservice;
	
	@RequestMapping(value = "/jobRecruiter", method = { RequestMethod.GET, RequestMethod.POST })
	public String addJobRecruiter( JobRecruiter job) 
	{
		 recruiterservice.addJobRecruiter(job);
		return "jobRecruiter.jsp";
	}
}
