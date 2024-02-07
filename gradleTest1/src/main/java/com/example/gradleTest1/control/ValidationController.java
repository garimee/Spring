package com.example.gradleTest1.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gradleTest1.DAO.MemberDao;
import com.example.gradleTest1.DTO.MemberDto;

@Controller
public class ValidationController {
	
	@Autowired
	private MemberDao memberDao;

	// 유효성 검사 2 - form 입력 양식 페이지
	@GetMapping("/valid2")  
	public String input(Model model) {
		model.addAttribute("memberDto", new MemberDto());
		return "signup";
	}
	
	@GetMapping("/submit")
	public String input(@Valid MemberDto memberDto, BindingResult bind, Model model) {
	if( bind.hasErrors()) {
			return "signup";
		}
	
	memberDao.insertMember(memberDto);
	
	List<MemberDto> list = memberDao.list();
	
	model.addAttribute("list", list);
	
		return "signupResult";
	}
}







