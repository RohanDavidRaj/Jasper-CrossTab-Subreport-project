package com.tyc.firstjasper.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyc.ems.dto.ResponseDto;
import com.tyc.firstjasper.service.EmployeeServiceImplementation;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@RequestMapping("/mentor")
public class MentorController {

	@Autowired
	EmployeeServiceImplementation service;
	
	@Autowired
	DataSource dataSource;

	@GetMapping("/getAll")
	public ResponseEntity<byte[]> getAll() throws FileNotFoundException, JRException, SQLException {
        
         JasperReport compileReport = JasperCompileManager.
         compileReport
         (new FileInputStream("C:\\Users\\chait\\Desktop\\Spring Project\\Jasper\\jasperFilter\\emp.jrxml"));
         
	   
         HashMap<String, Object> map=new HashMap<>();
         JasperPrint fillReport = JasperFillManager.fillReport(compileReport,map, dataSource.getConnection());
       
         //for exporting in our our file path and return 
         // JasperExportManager.exportReportToPdfFile(fillReport,"C:\\Users\\chait\\Desktop\\Spring Project\\empDetails.pdf");
        // return new ResponseEntity<ResponseDto>(new ResponseDto(false, " Data ", ""), HttpStatus.OK);
       
         //for downloading 
         byte[] exportReportToPdf = JasperExportManager.exportReportToPdf(fillReport);    
         HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION,"inline;filename=employeeDetails.pdf");
         return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF).body(exportReportToPdf);
       
         

	}

}
