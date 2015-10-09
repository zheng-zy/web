package com.zzy.sssp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzy.sssp.entity.Employee;
import com.zzy.sssp.repository.EmployeeRepository;

/**
 * EmployeeService.java 说明
 * 
 * @author zhengzy
 * @date 2015年10月9日上午10:23:21
 */
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional(readOnly=true)
	public Employee getByLastName(String lastName){
		return employeeRepository.getByLastName(lastName);
	}

	@Transactional(readOnly=true)
	public Page<Employee> getPage(int pageNo, int pageSize) {
		PageRequest pageable = new PageRequest(pageNo - 1, pageSize);
		return employeeRepository.findAll(pageable);
	}
}
