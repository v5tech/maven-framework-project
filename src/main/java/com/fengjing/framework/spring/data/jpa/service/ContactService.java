package com.fengjing.framework.spring.data.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fengjing.framework.springmvc.model.Contact;

public interface ContactService {
	
	Contact findById(int id);
	
	Contact save(Contact contact);
	
	Contact modifyContact(Contact contact);
	
	void delete(Contact contact);
	
	void delete(int id);
	
	Page<Contact> findAll(Pageable pageable);
	
	List<Contact> listAll();
	
	/**
	 * 查询年龄小于150岁 且按Id降序排列
	 * @param age
	 * @param pageable
	 * @return
	 */
	Page<Contact> findByAgeLessThanEqualOrderByIdDesc(int age,Pageable pageable);
	
}
