package com.sunbeam.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// application level exception handling -- will execute for all controllers
@RestControllerAdvice // @ControllerAdvice + @ResponseBody
public class ExceptionHandlingAdvice {
	@ExceptionHandler
	public ResponseUtil<?> handleException(Throwable ex) {
		return ResponseUtil.apiError(ex.getMessage());
	}
}
