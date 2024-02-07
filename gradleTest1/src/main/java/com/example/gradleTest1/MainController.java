package com.example.gradleTest1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.gradleTest1.DTO.MyInfoDTO;
import com.example.gradleTest1.DTO.person;

@Controller
public class MainController {
	// 클라이언트의 요청을 처리해주는 클래스
	
	@GetMapping("/")
	public ModelAndView main() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("name","최무선");
		return  mv;
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("testKey","테스트중 박문수");
		return "test";
	}
	
	@GetMapping("/form")
	public String formData() {
		return "form";
	}
	
	@RequestMapping("/input")
	public String input(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("myId");
		String name = request.getParameter("myName");
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		
		return "input1";
	}
	
	@GetMapping("/input2")
	public String input(@RequestParam("myId") String id , 
			@RequestParam("myName") String name, Model model) {
		
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		
		return "input2";		
	}
	
	@GetMapping("/input3")
	public String input( person person , Model model) {
		return "input3";
	}
	
	@GetMapping("/input4/{id}/{name}")
	public String input4(@PathVariable String id, @PathVariable String name,
			 Model model) {
		
		return "input4";
	}
	
	
	@GetMapping("/testIn")
	public String inputInfo() {
		return "testInput";
	}
	
	@GetMapping("/Info")
	public String myInfo( MyInfoDTO myInfoDTO , Model model) {
		
		String ageTmp = myInfoDTO.getAge(); //28
		if(ageTmp.length()==1)
			ageTmp = "10살미만";
		else
			ageTmp = ageTmp.substring(0,1)+"0대";
		
		model.addAttribute("age", ageTmp );
		
		return "myInfo";
	}
	
	
}


/*
	모델  
	스프링에서 모델은 데이터를 저장하거나 뷰에 전달하기 위한 용도로 사용된다.
	   ModelAndView - 데이터와 뷰를 모두 전달할수 있다.
	   
	   Model - 데이터만 전달 가능
	   
	   사용자 요청에 의한 전달받은 데이터를 다시 사용자 화면에 제공하는 방법은
	   model 사용 해야한다. 
	   사용자의 요청에 의한 발생된 데이터는 파라미터로 들어오는데 파라미터는 페이지가 변경되면
	   사라진다.  파라미터가 사라지기전에 모델에 저장 해두어야한다.
	   
	   
	   
	   네이밍 규칙 ( 권고사항? -반드시 하지않아도 되지만 대체적으로 이렇게 쓴다.)
	   
	   공통부분
	     1. 대소문자 구분
	     2. 예약어 사용 하면안됨 ( 예. int , String )
	     3. 숫자로 시작하면 안됨
	     4. 특수문자는 _ 또는 $만 허용
	     5. 파스칼 표기법 또는 카멜 표기법 사용
	       카멜 - myName , 파스칼 - MyName
	     6. 반의어는 반드시 대응하는 개념으로 사용
	     
	   프로젝트 이름
	      - 대소문자 구분없이 사용가능 하지만 대문자 사용을 권장
	   
	   패키지 이름
	      - 대소문자 모두 사용가능 하지만 클래스명과 구분을 위해 소문자 사용 권장
	      - 가급적 한단어 사용 권장
	        com.naver.comic.member 올바른 예
	        com.naver.comicMember  안좋은 예
	   
	   클래스 
	     - 파스칼표기법 사용
	     - 명사로 시작
	   
	   메서드
	     - 카멜표기법 사용
	     - 동사로 시작
	     메서드명의 접두사(일반적)
	       속성에 접근 : get/set
	       데이터 
	          생성 : create
	          조회 : find
	          변경 : update/modify
	          삭제 : delete
	          입력 : input/insert
	          초기화 : init
	          파일불러오기 : load
	          파일저장 : save
	          유무 확인 : has
	          A를 기준으로 B를 : By
	               getAgeByBirth() 
	               getElementById()
	               
	  변수  - 카멜 표기법
	  상수 - 전부 대문자 , 스네이크 표기법
	  
	  
	  신입 개발자들이 자주 하는 나쁜습관?
	    1. 임의적인 postfix 사용 
	       - 학교나 학원 또는 독학할때 다룬 주소네이밍을 사용한다. ( .do )  
	    2. 확인을 위해 System.out.println을 사용한다.
	      - 테스트나 공부의 목적으로 빠르게 확인 하기 위해 사용하지만 
	        실제 서비스에서는 console로 출력하거나  로그기록이 남도록 파일저장을 해야한다.
	        
	    3. 코드에 주석처리 하고 왜 주석 을 했는가 아무말도 남기지 않는다.
	      - 주석처리를 했다면 다른 사람이 보거나  나중에 내가 다시 볼때 왜 주석을 했는지 이유가 있어야
	        알아볼수 있다.  아무 기록도 안하고 주석 할꺼면 그냥 삭제 하기
	        
	    4. 변수이름에 _ 넣는다.
	       - 변수는 카멜표기법으로 작성한다.
	       - 대부분의 개발자들이 카멜표기법으로 작성하는데  나혼자 _ 넣거나 다른 방식으로 작성하면
	          따돌림 당한다.
	          
	    5. 메서드 이름에서 형용사나 명사를 앞쪽에 넣는다.
	      - newUser ,  anyData   -> 이렇게 하면 안된다. !!
	      - createUser, saveMemberData
	      
	    6. 필요 이상으로 if문 많이 활용
	      - if문은 최소화 하는게 좋다. (map을 활용하든가,switch문이나, callback, 재귀 등등)
	      
	    7. parameter가 많은데  그냥 변수로 받는다.
	      - form 입력 데이터가  10가지 인데  @RequestParam으로 하나하나 다받는다.
	      - 파라미터가 많은경우 객체로 받는게 좋다.
	      
	    8. 불필요한 로그를 넣는다.
	      - 코드가 잘 동작하는지 테스트를 위해 System.out.println을 사용하는데 
	      - 테스트가 끝났으면 삭제 하도록 하기!!! 또는 주석 달거나!!!
	    
	    9. 라이브러리를 활용하지 않는다.
	      - 데이터 저장 을 위해 클래스를 정의하는데  직접 get/set/ toString 을 작성한다.
	      - 객체에 데이터를 하나하나 직접 저장 시킨다.
	      - 라이브러리를 사용하면 쉽게 빠르게 작업 이 가능한데 어려운 길을 간다.
	    10. 가능한 적은 코드로 작성 하지 않으려 한다.
	    11. 사용자 편의성을 고려하지않는다.
	      

*/






