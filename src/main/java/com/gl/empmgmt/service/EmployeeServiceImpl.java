package com.gl.empmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.empmgmt.dao.EmployeeDao;
import com.gl.empmgmt.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao empdao;

	public EmployeeServiceImpl(EmployeeDao empdao) {
		super();
		this.empdao = empdao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empdao.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empdao.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empdao.save(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return empdao.findById(id).get();
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		empdao.deleteById(id);
	}

}
