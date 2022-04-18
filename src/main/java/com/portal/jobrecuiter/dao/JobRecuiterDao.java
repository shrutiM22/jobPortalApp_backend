package com.portal.jobrecuiter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.jobrecruiter.entity.JobRecruiter;

@Repository
public interface JobRecuiterDao extends JpaRepository<JobRecruiter, Integer>{

}
