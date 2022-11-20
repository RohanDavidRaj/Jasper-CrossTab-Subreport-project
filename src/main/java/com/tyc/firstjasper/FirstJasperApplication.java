package com.tyc.firstjasper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.sf.jasperreports.engine.JRException;

@SpringBootApplication
public class FirstJasperApplication {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(FirstJasperApplication.class, args);

//			String filePath="C:\\Users\\chait\\Desktop\\Spring Project\\Jasper"
//					+ "\\FirstJasper\\src\\main\\resources\\Simple_Blue.jrxml";
//
//			Map<String, Object> paramters =  new HashMap<String,Object>();
//			paramters.put("studentName","rohan");
//
//			Student student=new Student(1,"sff","raj","90feet","mumbai");
//			Student student1=new Student(2,"jhon","li","90feet","chennai");
//
//		  List<Student> list=new ArrayList<>();
//		  list.add(student1);
//		  list.add(student);
//
//		  JRBeanCollectionDataSource beanCollectionDataSource
//		  = new JRBeanCollectionDataSource(list);
//
//		JasperReport compileReport = JasperCompileManager.compileReport(filePath);
//
//	JasperPrint print=
//			JasperFillManager.fillReport(compileReport, paramters,beanCollectionDataSource);
//
//	JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\chait\\Desktop\\Jasper\\first.pdf");
//
//		System.out.println("report created");
//
	}

}
