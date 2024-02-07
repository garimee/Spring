package com.example.gradleTest1.DTO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberDto {
	
	private String email;
	
	@NotBlank(message="name is not input")
	private String name;
	
	private String password;
	
	private String city;
	
	private String state;
	
	private String zipCode;
}

/*
		@NotNull  - null 불가
		@Null - null만 입력 가능
		@NotEmpty -  null, 빈문자열 불가
		@NotBlack - null, 빈문자열, 스페이스공간 불가
		@Size(min , max) - 문자열, 배열의 크기가 만족한가?
		@Pattern(regex=) - 정규식 만족?
		@Max(숫자) - 지정값 이하?
		@Min(숫자) - 지정값 이상?
		@Email - 이메일 형식인가?
		@Digits(integer, fraction) - 지정된 정수와 소수자리 만족?
		@Future - 지금 보다 앞일인가?  미래
		@Past - 지금보다 과거인가?
 */












