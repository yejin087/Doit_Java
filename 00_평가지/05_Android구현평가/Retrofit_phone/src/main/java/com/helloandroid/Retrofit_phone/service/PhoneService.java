package com.helloandroid.Retrofit_phone.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloandroid.Retrofit_phone.model.Phone;
import com.helloandroid.Retrofit_phone.repository.PhoneRepository;

@Service
public class PhoneService {

	@Autowired
	PhoneRepository phoneRepository;

	public Phone save(Phone phone) {
		return phoneRepository.save(phone);
	}

	public List<Phone> findAll() {
		return phoneRepository.findAll();
	}

	public void deleteById(Long id) {
		phoneRepository.deleteById(id);
	}

	@Transactional
	public Phone update(Long id, Phone phone) {
		Phone persist = phoneRepository.findById(id).get();
		persist.setName(phone.getName());
		persist.setTel(phone.getTel());
		return persist;
	}
}
