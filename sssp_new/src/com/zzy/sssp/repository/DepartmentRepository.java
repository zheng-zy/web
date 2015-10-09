package com.zzy.sssp.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.zzy.sssp.entity.Department;

/**
 * DepartmentRepository.java 说明
 * @author zhengzy
 * @date   2015年10月9日下午2:52:43
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	@QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE, value="true")})
	@Query("FROM Department d")
	List<Department> getAll();
	
}
