package com.gcu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	@Autowired
    JdbcTemplate jdbcTemplate;


    public List<Map<String,Object>> fetchAll(String myId) 
    {
        List<Map<String,Object>> getAllUser = jdbcTemplate.queryForList(
        		"SELECT * FROM user where id!=?", myId);

        return getAllUser;
    }
}
