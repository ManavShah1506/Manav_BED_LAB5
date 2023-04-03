package com.gl.empmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.empmgmt.model.Employee;
import com.gl.empmgmt.service.EmployeeService;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	EmployeeService empservice;

	public EmployeeController(EmployeeService empservice) {
		super();
		this.empservice = empservice;
	}

	@GetMapping()
	public String showEmpList(Model model) {
		model.addAttribute("emps", empservice.getAllEmployees());
		return "employees-list";
	}

	@GetMapping("/new")
	public String createEmp(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee";
	}

	@GetMapping("/edit/{id}")
	public String updateEmp(Model model, @PathVariable int id) {
		Employee employee = empservice.getEmployee(id);
		model.addAttribute("employee", employee);
		return "employee";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmp(Model model, @PathVariable int id) {
		empservice.deleteEmployee(id);
		return "redirect:/employees";
	}

	@PostMapping("/saveEmp")
	public String saveEmp(Model model, @ModelAttribute("employee") Employee employee) {
		empservice.saveEmployee(employee);
		return "redirect:/employees";
	}

}
