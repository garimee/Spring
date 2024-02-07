package com.example.gradleTest1.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.gradleTest1.DTO.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	public List<MemberDto> list() {
		String sql = "select * from myuser";
		List<MemberDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<MemberDto>());
		return list;
	}
	
	public void insertMember(MemberDto memberDto) {
		String sql = "insert into myuser(email, name, pw, city, state, zip_code" + "values(?, ?, ?, ?, ?, ?))"; 
		jdbcTemplate.update(sql, memberDto.getEmail(), memberDto.getName(), memberDto.getPassword(), memberDto.getCity(), memberDto.getState(), memberDto.getZipCode());
	}
}
