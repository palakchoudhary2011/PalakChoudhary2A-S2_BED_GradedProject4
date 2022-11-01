package com.gl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Role;
import com.gl.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public Role addRole(Role role)
	{
		return roleRepository.saveAndFlush(role);
	}
	
}
