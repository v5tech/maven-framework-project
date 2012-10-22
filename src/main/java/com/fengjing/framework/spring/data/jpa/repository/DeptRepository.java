package com.fengjing.framework.spring.data.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.fengjing.framework.springmvc.model.Dept;

/**
 * 
 * @author fengjing
 *
 */
public interface DeptRepository extends PagingAndSortingRepository<Dept, Integer> {

}
