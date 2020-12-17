package com.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.TestDao;

@Service
public class TestService {
	@Autowired
	private TestDao testDao;
	
	public String getTestVO() {
		return testDao.getTestVO();
	}
}
