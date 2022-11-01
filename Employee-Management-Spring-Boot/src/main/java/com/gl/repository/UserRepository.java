package com.gl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	public User findByUsername(String username);
}
