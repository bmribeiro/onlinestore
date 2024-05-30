package com.onlinestore.javarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.onlinestore.javarest.entities.Address;
import com.onlinestore.javarest.repository.AddressRepository;

import jakarta.persistence.EntityManagerFactory;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public List<Address> getAllAddresses() {
		return (List<Address>) addressRepository.findAll();
	}

}