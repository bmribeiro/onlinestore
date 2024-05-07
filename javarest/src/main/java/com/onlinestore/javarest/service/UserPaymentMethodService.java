package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.UserPaymentMethod;
import com.onlinestore.javarest.repository.UserPaymentMethodRepository;

@Service
public class UserPaymentMethodService {

    @Autowired
    private UserPaymentMethodRepository userPaymentMethodRepository;

    public List<UserPaymentMethod> getAllUserPaymentMethods() {
        return (List<UserPaymentMethod>) userPaymentMethodRepository.findAll();
    }

}