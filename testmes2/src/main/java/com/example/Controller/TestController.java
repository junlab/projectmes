package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Services.TestService;

@RestController
public class TestController {
	@Autowired
	private TestService testService;
	
	@GetMapping(value="/getTestVO")
	public String checkDB(){
		return testService.getTestVO();
	}
}
