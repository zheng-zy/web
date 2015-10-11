package com.zzy.sssp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@Transactional
	public void delete(Integer id){
		employeeRepository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Employee get(Integer id){
		return employeeRepository.findOne(id);
	}
	
	@Transactional
	public void save(Employee employee) {
		if(employee.getId() == null){
			// 设置创建时间
			employee.setCreateTime(new Date());
		}
		employeeRepository.saveAndFlush(employee);
	}

	@Transactional(readOnly = true)
	public Employee getByLastName(String lastName) {
		return employeeRepository.getByLastName(lastName);
	}

	@Transactional(readOnly = true)
	public Page<Employee> getPage(int pageNo, int pageSize) {
		PageRequest pageable = new PageRequest(pageNo - 1, pageSize);
		return employeeRepository.findAll(pageable);
	}
}
