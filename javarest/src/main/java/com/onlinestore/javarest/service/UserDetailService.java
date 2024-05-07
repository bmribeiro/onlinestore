package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.UserDetail;
import com.onlinestore.javarest.repository.UserDetailRepository;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailsRepository;

    public List<UserDetail> getAllUserDetail() {
		return (List<UserDetail>) userDetailsRepository.findAll();
    }

}