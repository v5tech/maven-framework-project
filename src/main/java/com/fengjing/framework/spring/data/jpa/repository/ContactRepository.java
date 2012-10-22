package com.fengjing.framework.spring.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fengjing.framework.springmvc.model.Contact;

/**
 * Spring Data Jpa Repository
 * @author fengjing
 *
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer>{
	
	/**
	 * 该方法实际上是查询com.fengjing.framework.model.Contact 中的@NamedQuery(name="findById",query="select a from Contact a where a.id= ?1")
	 * @see com.fengjing.framework.model.Contact<br/>@NamedQuery(name="Contact.findById",query="select a from Contact a where a.id= ?1")
	 * @param id
	 * @return
	 */
	Contact findById(int id);
	
	/**
	 * 查询年龄小于150岁 且按Id降序排列
	 * @param age
	 * @param pageable
	 * @return
	 */
	Page<Contact> findByAgeLessThanEqualOrderByIdDesc(int age,Pageable pageable);
	
}
