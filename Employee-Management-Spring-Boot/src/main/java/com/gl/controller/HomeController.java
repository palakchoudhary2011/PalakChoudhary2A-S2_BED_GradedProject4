package com.gl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.entity.Employee;
import com.gl.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class HomeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return employeeService.addEmployee(employee);
	
	}
	@GetMapping("/employees")
	public List<Employee> listEmployees()
	{
		return employeeService.listEmployees();
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		Optional<Employee> emp=employeeService.getEmployeeById(id);
		if(emp.isPresent())
		{
			return emp.get();
		}
		return null;//throw exception 
	}
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/employees/search/{username}")
	public List<Employee> fetchEmployeeByFirstName(@PathVariable String username)
	{
		return employeeService.fetchEmployeeByFirstName(username);		
	}
	@GetMapping("/employees/sort")
	public List<Employee> listAllEmployeesSortedByUsername(@RequestParam(value="order") String order)
	{
			if(order.equals("desc"))
				return employeeService.listAllEmployeesSortedByUsernameAsc(Direction.DESC);
			else 
				return employeeService.listAllEmployeesSortedByUsernameAsc(Direction.ASC);
			
			
	}
	
}
