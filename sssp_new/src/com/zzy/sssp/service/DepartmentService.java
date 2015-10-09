package com.zzy.sssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzy.sssp.entity.Department;
import com.zzy.sssp.repository.DepartmentRepository;

/**
 * DepartmentService.java 说明
 * @author zhengzy
 * @date   2015年10月9日下午3:22:33
 */
@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional(readOnly=true)
	public List<Department> getAll(){
		return departmentRepository.getAll();
	}
}
