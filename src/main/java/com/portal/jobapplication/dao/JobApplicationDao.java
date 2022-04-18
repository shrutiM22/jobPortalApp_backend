package com.portal.jobapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.jobapplication.entity.JobApplication;

@Repository
public interface JobApplicationDao extends JpaRepository<JobApplication, Integer> {

}
