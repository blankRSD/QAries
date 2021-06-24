package com.teamone.postgres.contracts;

import java.util.List;

import com.teamone.postgres.entity.Emp;

public interface IEmpDAO {
	public boolean insertEmp(Emp emp);

	public Emp getEmp(int empId);

	public List<Emp> getAllEmps();

	public Emp updateEmp(Emp emp);

	public void deleteEmp(int empId);
}
