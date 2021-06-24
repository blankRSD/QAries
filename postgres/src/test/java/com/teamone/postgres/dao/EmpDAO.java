package com.teamone.postgres.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teamone.postgres.contracts.IEmpDAO;
import com.teamone.postgres.entity.Emp;
import com.teamone.postgres.util.GetConnection;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmpDAO implements IEmpDAO{

	GetConnection gc ; 
	public EmpDAO() {
		gc = new GetConnection(); 
	}
	
	/**
	 * @author naveenkumar 
	 * @see To insert record in to db 
	 */
	public boolean insertEmp(Emp emp) {
		String sql="insert into emp values (?,?,?)"; 
		
		try {
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql);
			gc.ps.setInt(1, emp.getEmpId());
			gc.ps.setString(2, emp.getEmpName());
			gc.ps.setDouble(3, emp.getEmpSal());
			
			return gc.ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gc.ps.close();
				gc.rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return false;
	}

	public Emp getEmp(int empId) {
		String sql="select empname, empsal from emp where empid=?"; 
		try {
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql); 
			gc.ps.setInt(1, empId);
			
			gc.rs = gc.ps.executeQuery(); 
			if(gc.rs.next()) {
				Emp emp = new Emp(); 
				emp.setEmpId(empId);
				emp.setEmpName(gc.rs.getString(1));
				emp.setEmpSal(gc.rs.getDouble(2));
				return emp;
			}else {
				log.info("Record Not Found for " + empId );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				gc.ps.close();
				gc.rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public List<Emp> getAllEmps() {
		String sql ="select empid, empname, empsal from emp";
		
		List<Emp> list = null;
		try {
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql);
			list = new ArrayList<Emp>();
			
			gc.rs = gc.ps.executeQuery(); 
			while(gc.rs.next()) {
				Emp emp = new Emp(); 
				emp.setEmpId(gc.rs.getInt(1));
				emp.setEmpName(gc.rs.getString(2));
				emp.setEmpSal(gc.rs.getDouble(3));
				list.add(emp); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				gc.ps.close();
				gc.rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public Emp updateEmp(Emp emp) {
		String sql="UPDATE emp SET empName = ?,empSal = ? WHERE empid = ?"; 
		boolean success = false;
		try {
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql);
	
			gc.ps.setString(1, emp.getEmpName());
			gc.ps.setDouble(2, emp.getEmpSal());
			gc.ps.setInt(3, emp.getEmpId());
			success = gc.ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return success ? emp:null;
	}

	
	public void deleteEmp(int empId) {
		String sql="DELETE FROM emp where empid=?"; 
		try {
			gc.ps = GetConnection.getPostGressConn().prepareStatement(sql); 
			gc.ps.setInt(1, empId);
			
			boolean status = gc.ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	
}
