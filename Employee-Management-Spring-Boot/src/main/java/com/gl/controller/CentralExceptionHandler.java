package com.gl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gl.customexceptionjson.CustomJson;

@ControllerAdvice
public class CentralExceptionHandler {
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=UsernameNotFoundException.class)
	public CustomJson UsernameNotFoundExceptionHandler()
	{
		return new CustomJson("username not found");
	}
	
}
