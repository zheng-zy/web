package com.zzy.sssp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzy.sssp.entity.Employee;

/**
 * EmployeeRepository.java 说明
 * @author zhengzy
 * @date   2015年10月9日上午10:19:52
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee getByLastName(String lastName);
}
