package com.example.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private String nameSpace = "TestMapper.";
	
	public String getTestVO() {
		return sqlSessionTemplate.selectOne(nameSpace+"getTestVO");
	}
}
