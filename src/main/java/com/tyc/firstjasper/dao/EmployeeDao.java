package com.tyc.firstjasper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyc.firstjasper.entity.EmployeePrimary;

public interface EmployeeDao extends JpaRepository<EmployeePrimary, Integer>{

	 EmployeePrimary findByEmployeeId(String empId);

	// Optional<EmployeePrimary> findByEmployeeId(String empId);

	 List<EmployeePrimary> findByEmpName(String empName);

	 List<EmployeePrimary> findAllByDeleted(boolean deleted);

	// @org.springframework.data.jpa.repository.Query(value = "",nativeQuery = true)
	 EmployeePrimary findByEmpNameAndEmployeeId(String name,String empId);






}
