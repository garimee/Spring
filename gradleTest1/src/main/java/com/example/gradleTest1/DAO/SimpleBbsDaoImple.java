package com.example.gradleTest1.DAO;

import java.util.List;

import com.example.gradleTest1.DTO.SimpleBbsDto;

public interface SimpleBbsDaoImple {
	
	public List<SimpleBbsDto> listDao();
	public SimpleBbsDto viewDao(String id);
	public int writeDao(SimpleBbsDto simpleBbsDto);
	public int deleteDao(String id);
}
