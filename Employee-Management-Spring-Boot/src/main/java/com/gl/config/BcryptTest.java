package com.gl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class BcryptTest {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		String pass=passwordEncoder.encode("admin");
		
			
		
		System.out.println(pass);
	}

}
