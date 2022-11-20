package com.tyc.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeDto {

	private int Id;

	private String employeeId;

	private String empName;

	private String empDesignation;

	private String dob;

	private String empEmail;

	private String phoneNumber;

}
