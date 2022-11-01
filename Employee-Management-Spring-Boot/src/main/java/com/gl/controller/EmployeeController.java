package com.gl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.entity.Employee;
import com.gl.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return employeeService.addEmployee(employee);
	
	}
	@GetMapping("/employees")
	public List<Employee> listEmployees()
	{
		return employeeService.listEmployees();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		Optional<Employee> emp=employeeService.getEmployeeById(id);
		if(emp.isPresent())
		{
			return ResponseEntity.of(Optional.of(emp.get()));//emp.get();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//throw exception 
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id)
	{	
		Optional<Employee> emp=employeeService.getEmployeeById(id);
		if(emp.isPresent())
		{	
			employeeService.deleteEmployee(id);
			return ResponseEntity.of(Optional.of(emp.get()));//emp.get();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/employees/search/{username}")
	public ResponseEntity<List<Employee>> fetchEmployeeByFirstName(@PathVariable String username)
	{
		//return employeeService.fetchEmployeeByFirstName(username);	
		List<Employee> emp=employeeService.fetchEmployeeByFirstName(username);
		if(emp.isEmpty())
		{	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			
		}
		return ResponseEntity.of(Optional.of(emp));//emp.get();
		
	}
	@GetMapping("/employees/sort")
	public List<Employee> listAllEmployeesSortedByUsername(@RequestParam(value="order") String order)
	{
			if(order.equals("desc"))
				return employeeService.listAllEmployeesSortedByUsername(Direction.DESC);
			else 
				return employeeService.listAllEmployeesSortedByUsername(Direction.ASC);
			
			
	}
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Optional<Employee> e1=employeeService.getEmployeeById(employee.getId());
		if(e1.isPresent())
		{
			e1.get().setFirstName(employee.getFirstName());
			e1.get().setLastName(employee.getLastName());
			e1.get().setEmail(employee.getEmail());
			employeeService.addEmployee(e1.get());
			return ResponseEntity.of(Optional.of(e1.get()));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
}
