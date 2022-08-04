package com.helloandroid.Retrofit_phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helloandroid.Retrofit_phone.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
