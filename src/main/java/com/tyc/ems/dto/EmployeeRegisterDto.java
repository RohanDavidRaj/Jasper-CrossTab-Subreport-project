package com.tyc.ems.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDto {


	private String employeeId;

	@NotEmpty(message = "Username Should Not Null")
	@Size(min = 4,message = "Username Must Be Min of 4 Character")
	@Size(max = 15,message = "Username Must Be less than 15 Character ")
	@Pattern(regexp = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", message = "only Character ")
	private String empName;

	private String empDesignation;

	private String dob;

	@NotEmpty(message = "Email Should Not Null")
	@Email(message = "Email Is Not Valid")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*(@gmail)+(\\.com||.in)$",message = "Email Pattern Is Not Correct. Try This - (@gmail.com)")
	private String empEmail;


	@NotEmpty(message = "Phone Number Should Not Null")
	@Size(min = 10,message = "Numbers Should Be 10 Digits")
	@Size(max = 10,message = "Numbers Should Be Not Greater Than 10 Digits")

	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone Number Is Not Valid")
	private String phoneNumber;



}
