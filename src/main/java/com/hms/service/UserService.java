package com.hms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entity.*;
import com.hms.repository.EmpRepo;

@Service
public class UserService {
    @Autowired
    private EmpRepo repo;
    public void addUser(User u){
        repo.save(u);
    }
    public User findByUserName(String userName) {
        return repo.findByUserName(userName);
    }
}
