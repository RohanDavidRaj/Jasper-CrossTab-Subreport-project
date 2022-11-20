package com.tyc.firstjasper.service;

import java.util.List;

import com.tyc.ems.dto.EmployeeRegisterDto;
import com.tyc.ems.dto.EmployeeUpdateDto;
import com.tyc.ems.dto.GetEmployeeDto;


public interface EmployeeService {


	public EmployeeRegisterDto register(EmployeeRegisterDto dto);

	public EmployeeUpdateDto update(EmployeeUpdateDto dto);

	public boolean delete(String empId);

//
//	public GetEmployeeDto getEmployee(String empId);
//
	public GetEmployeeDto getEmployeeByEmpId(String empId);

//
	public List<GetEmployeeDto> get();

//
	public List<GetEmployeeDto> getEmployeeByName(String empName);

}
