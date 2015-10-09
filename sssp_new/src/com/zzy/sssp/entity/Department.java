package com.zzy.sssp.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Department.java 说明
 * @author zhengzy
 * @date   2015年10月9日上午9:51:34
 */
@Cacheable
@Table(name="SSSP_DEPARTMENTS")
@Entity
public class Department {
	private Integer id;
	private String departmentName;
	
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
