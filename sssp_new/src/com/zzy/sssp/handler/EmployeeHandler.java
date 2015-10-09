package com.zzy.sssp.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzy.sssp.entity.Employee;
import com.zzy.sssp.service.DepartmentService;
import com.zzy.sssp.service.EmployeeService;

/**
 * EmployeeHandler.java 说明
 * 
 * @author zhengzy
 * @date 2015年10月9日上午10:32:30
 */
@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	
	@ResponseBody
	@RequestMapping(value="/ajaxValidateLastName", method=RequestMethod.POST)
	public String validateLastName(@RequestParam(value="lastName", required=true)String lastName){
		Employee employee = employeeService.getByLastName(lastName);
		if (employee == null){
			return "0";
		}else{
			return "1";
		}
	}
	
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map){
		map.put("departments", departmentService.getAll());
		map.put("employee", new Employee());
		return "emp/input";
	}

	@RequestMapping("/emps")
	public String list(@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNoStr, Map<String, Object> map) {
		int pageNo = 1;
		try {
			// 对pageNo的校验
			pageNo = Integer.parseInt(pageNoStr);
			if (pageNo < 1) {
				pageNo = 1;
			}
		} catch (Exception e) {
		}
		
		Page<Employee> page = employeeService.getPage(pageNo, 5);
		map.put("page", page);
		return "emp/list";
	}
}
