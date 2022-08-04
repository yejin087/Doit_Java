package com.helloandroid.Retrofit_phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helloandroid.Retrofit_phone.model.Phone;
import com.helloandroid.Retrofit_phone.service.PhoneService;

@RestController
public class PhoneController {

	@Autowired
	PhoneService phoneService;

	@PostMapping("insert")
	public Phone save(@RequestBody Phone phone) {
		System.out.println("kkkk");
		return phoneService.save(phone);
//		System.out.println(phone.toString());
	}

	@GetMapping("list")
	public List<Phone> list() {
		return phoneService.findAll();
	}

	@DeleteMapping("delete/{id}")
	public void delteById(@PathVariable Long id) {
		phoneService.deleteById(id);
	}

	@PutMapping("update/{id}")
	public Phone update(@PathVariable Long id, @RequestBody Phone phone) {
		return phoneService.update(id, phone);
	}
}
