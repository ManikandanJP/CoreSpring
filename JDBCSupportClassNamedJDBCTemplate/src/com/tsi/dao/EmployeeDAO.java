package com.tsi.dao;

import com.tsi.dto.Employee;

public interface EmployeeDAO {

	public String Add(Employee employee);

	public Employee search(int eno);

	public String update(Employee employee);

	public String delete(int eno);
	
}
