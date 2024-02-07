package com.example.gradleTest1.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.gradleTest1.DAO.SimpleBbsDaoImple;
import com.example.gradleTest1.DTO.SimpleBbsDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BbsController {

	@Autowired
	SimpleBbsDaoImple simpleBbsDaoImple;
	
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String root(Model model) {
		model.addAttribute("list", simpleBbsDaoImple.listDao());
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String writer(@Valid SimpleBbsDto simpleBbsDto, BindingResult bind, Model model) {
		// 작성한 내용을 유효성 검사하고 데이터베이스에 저장하기 
		if(bind.hasErrors())
		simpleBbsDaoImple.writeDao(simpleBbsDto);
		return "redirect:/board";
	}	
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable String id, Model model) {
		model.addAttribute("dto", simpleBbsDaoImple.viewDao(id));
		return "view";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		simpleBbsDaoImple.deleteDao(id);
		return "redirect:/board";
	}



}