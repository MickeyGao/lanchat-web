package service;

import java.util.List;

import model.Department;

import dao.DepartmentDao;

public class DepartmentManager {
	private DepartmentDao departmentDao;
	
	public List<Department> getAllDepartments(){
		departmentDao = new DepartmentDao();
		return departmentDao.ListAll();
	}
	
	public void addDepartment(Department department){
		departmentDao = new DepartmentDao();
		departmentDao.save(department);
	}
}
