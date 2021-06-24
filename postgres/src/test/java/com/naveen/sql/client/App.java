package com.naveen.sql.client;

import com.teamone.postgres.contracts.IEmpDAO;
import com.teamone.postgres.dao.EmpDAO;
import com.teamone.postgres.entity.Emp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
	public static void main(String[] args) {
//		Emp emp = new Emp(); 
//		emp.setEmpId(102);
//		emp.setEmpName("Aarsha");
//		emp.setEmpSal(2233);
	
		IEmpDAO dao = new EmpDAO(); 
		
		// insert 
//		log.info("{}",dao.insertEmp(emp)?"Record Inserted":  "Record Not Inserted" );
		 
		// get 1 record 
//		log.info("{}", dao.getEmp(103));
		
		// get all records 
		for(Emp emp : dao.getAllEmps()) {
			log.info("Records Got : {}", emp);
		}
		
	}
}
