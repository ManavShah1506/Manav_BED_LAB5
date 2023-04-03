package com.gl.empmgmt.service;

import java.util.List;

import com.gl.empmgmt.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();

	public Employee saveEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployee(int id);

	public void deleteEmployee(int id);

}
