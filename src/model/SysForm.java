package model;

import java.util.ArrayList;
import java.util.List;

public class SysForm {	// 系统表单类
	private List<UserId> userid;
	private List<Department> department;
	private List<Job> job;
	
	public void setId(List<UserId> userid){
		this.userid = new ArrayList<UserId>();
		for (int i = 0; i < userid.size(); i++){
			this.userid.add(userid.get(i));
		}
	}
	public void setDepartment(List<Department> department){
		this.department = new ArrayList<Department>();
		for (int i = 0; i < department.size(); i++){
			this.department.add(department.get(i));
		}
	}
	public void setJob(List<Job> job){
		this.job = new ArrayList<Job>();
		for (int i = 0; i < job.size(); i++){
			this.job.add(job.get(i));
		}
	}
	
	public List<UserId> getId(){
		return userid;
	}
	public List<Department> getDepartment(){
		return department;
	}
	public List<Job> getJob(){
		return job;
	}
}