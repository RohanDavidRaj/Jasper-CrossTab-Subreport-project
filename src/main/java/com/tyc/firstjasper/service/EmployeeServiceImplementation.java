package com.tyc.firstjasper.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyc.ems.dto.EmployeeRegisterDto;
import com.tyc.ems.dto.EmployeeUpdateDto;
import com.tyc.ems.dto.GetEmployeeDto;
import com.tyc.firstjasper.dao.EmployeeDao;
import com.tyc.firstjasper.entity.EmployeePrimary;
import com.tyc.firstjasper.exception.EmployeeException;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeDao dao;

	ModelMapper mapper=new ModelMapper();

	private int i;
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMyy");

	@Override
	public EmployeeRegisterDto register(EmployeeRegisterDto dto) {

		try {
			EmployeePrimary empObj = new EmployeePrimary();
			// dto.setPassword(encoder.encode(dto.getPassword()));
			// System.out.println(dto.getPassword());

			BeanUtils.copyProperties(dto, empObj);
			dao.save(empObj);
			i = empObj.getId();
			empObj.setEmployeeId("TYC" + myDateObj.format(myFormatObj) + String.format("%04d", i));
			dao.save(empObj);

			BeanUtils.copyProperties(empObj, dto);
			return dto;
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EmployeeException("something went wrong");
		}

	}

	@Override
	public EmployeeUpdateDto update(EmployeeUpdateDto dto) {

		if (dao.findByEmployeeId(dto.getEmployeeId()) != null) {
			EmployeePrimary empObj = dao.findByEmployeeId(dto.getEmployeeId());
			System.out.println("@@@@@@@@@@@@@@@loop");

			BeanUtils.copyProperties(dto, empObj);
			dao.save(empObj);
//			GetEmployeeDto getEmployeeDto = new GetEmployeeDto();
			BeanUtils.copyProperties(empObj, dto);

			return dto;
		} else {
			throw new EmployeeException("Id Not Found");

		}
	}

	@Override
	public boolean delete(String empId) {

		if (dao.findByEmployeeId(empId) != null) {
			EmployeePrimary findByEmpId = dao.findByEmployeeId(empId);
			findByEmpId.setDeleted(true);
			dao.save(findByEmpId);
			return true;
		}
		throw new EmployeeException("Id Not Found");

	}

	@Override
	public GetEmployeeDto getEmployeeByEmpId(String empId) {

		if (dao.findByEmployeeId(empId) != null) {
			EmployeePrimary findByEmpId = dao.findByEmployeeId(empId);

			GetEmployeeDto getEmployeeDto = new GetEmployeeDto(findByEmpId.getId(), findByEmpId.getEmployeeId(),
					findByEmpId.getEmpName(), findByEmpId.getEmpEmail(), findByEmpId.getEmpDesignation(),
					findByEmpId.getDob(), findByEmpId.getPhoneNumber());

			return getEmployeeDto;
		}
		throw new EmployeeException("Id Not Found");
	}

	@Override
	public List<GetEmployeeDto> get() {

//		 List<GetEmployeeDto> collect = dao.findAllByDeleted(false).stream().map(getEmployee->{
//
//			GetEmployeeDto getEmployeeDto = GetEmployeeDto.builder().build();
//			GetEmployeeDto.builder().employeeId(getEmployee.getEmployeeId())
//			.empName(getEmployee.getEmpName()).empDesignation(getEmployee.getEmpDesignation())
//			.empEmail(getEmployee.getEmpEmail()).dob(getEmployee.getDob()).phoneNumber(getEmployee.getPhoneNumber())
//			.build();
//
//			return getEmployeeDto;
//		}).collect(Collectors.toList());

	       List<EmployeePrimary> findAllByDeleted = dao.findAllByDeleted(false);
	       List<GetEmployeeDto>  dtos=new ArrayList<>();

	       findAllByDeleted.stream().forEach((emp) -> {
	    	   dtos.add(mapper.map(emp,GetEmployeeDto.class));
	       });
		return dtos;

			}


	@Override
	public List<GetEmployeeDto> getEmployeeByName(String empName) {

		try {
			if (dao.findByEmpName(empName).isEmpty()) {
				throw new EmployeeException("user with " + empName + " Is Not Presente");
			}
			List<EmployeePrimary> findAll = dao.findByEmpName(empName);
			System.out.println(findAll);

			List<GetEmployeeDto> dtos = new ArrayList<>();

			for (EmployeePrimary findByEmpId : findAll) {
				GetEmployeeDto employeeRegisterDto = new GetEmployeeDto();
				dtos.add(employeeRegisterDto);
			}
			System.out.println("@@@@@@@@@@@@" + dtos);
			return dtos;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EmployeeException("Something went wrong");

		}
	}

}
