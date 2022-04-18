package com.portal.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.user.entity.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {

}
