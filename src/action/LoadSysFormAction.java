package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import model.Job;
import model.SysForm;
import service.DepartmentManager;
import service.JobManager;
import service.UserIdManager;

@SuppressWarnings("serial")
public class LoadSysFormAction extends ActionSupport{
	private JobManager jobManager = new JobManager();
	private DepartmentManager departmentManager = new DepartmentManager();
	private UserIdManager useridManager = new UserIdManager();
	private Map<String, Object> responseJson;
	private SysForm sysForm = new SysForm();
	
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	
	public String execute() throws Exception{
		responseJson = new HashMap<String, Object>();
		
		List<Job> job = jobManager.getAllJobs();
		sysForm.setJob(job);
		
		sysForm.setDepartment(departmentManager.getAllDepartments());
		sysForm.setId(useridManager.getAllUserIds());
		
		responseJson.put("sysform", new Gson().toJson(sysForm, SysForm.class));
		
		if(responseJson!=null){
			System.out.println(responseJson.toString());
			return SUCCESS;
		}
		else {
			responseJson.put("sysform", null);
		}
		return "fail";
		
	}
}
