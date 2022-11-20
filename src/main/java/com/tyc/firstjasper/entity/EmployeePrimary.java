package com.tyc.firstjasper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Builder
@AllArgsConstructor
@Data

@NoArgsConstructor
@Table(name = "jasper_project")
public class EmployeePrimary {

//	@GenericGenerator(name = "empnextId", strategy = "com.ty.ems.controller.idgenerator.IdGenerator", parameters = {
//			@Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
//			@Parameter(name = IdGenerator.VALUE_PREFIX_PARAMETER, value = "TYC"),
//			@Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String employeeId;

	private String empName;
	private String empEmail;
	private String empDesignation;
	private String dob;
	private boolean deleted;

	@Column(name = "phone_number")
	private String phoneNumber;

}
