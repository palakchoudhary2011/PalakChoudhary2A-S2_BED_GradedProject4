package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.entity.Employee;
import com.gl.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee)
	{
		return employeeRepository.save(employee);		
	}
	
	public List<Employee> listEmployees()
	{
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(int id)
	{
		return employeeRepository.findById(id);
	}
	
	public void deleteEmployee(int id)
	{
		employeeRepository.deleteById(id);
	}
	
	public List<Employee> fetchEmployeeByFirstName(String username)
	{
		return employeeRepository.findByFirstName(username);
	}
	
	public List<Employee> listAllEmployeesSortedByUsername(Direction direction)
	{
		return employeeRepository.findAll(Sort.by(direction,"firstName"));
	}
	
//	public List<Employee> listAllEmployeesSortedByUsernameDesc(String firstName)
//	{
//		return employeeRepository.findAll(Sort.by(Direction.DESC,firstName));
//	}
//	
	
}
