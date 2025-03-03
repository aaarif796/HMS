package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.entity.User;

@Repository
public interface EmpRepo extends JpaRepository<User,Integer> {

    User findByUserName(String userName);
    
}