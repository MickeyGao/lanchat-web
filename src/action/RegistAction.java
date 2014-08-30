package action;

import java.util.HashMap;
import java.util.Map;

import model.User;

import service.UserManager;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RegistAction extends ActionSupport{
	private UserManager userManager = new UserManager();
	private Map<String, Object> responseJson;
	
	private String id;
	private String name;
	private String password;
	private int department;
	private int job;
	private String mphone;
	private String phone;
	private String email;
	
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public int getDepartment(){
		return department;
	}
	public int getJob(){
		return job;
	}
	public String getMphone(){
		return mphone;
	}
	public String getPhone(){
		return phone;
	}
	public String getEmail(){
		return email;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setDepartment(int department){
		this.department = department;
	}
	public void setJob(int job){
		this.job = job;
	}
	public void setMphone(String mphone){
		this.mphone = mphone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	
	public String execute() throws Exception{
		responseJson = new HashMap<String, Object>();
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setDepartment(department);
		user.setJob(job);
		user.setMphone(mphone);
		user.setPhone(phone);
		user.setEmail(email);
		user.setHeadpotrait("");
		user.setSignature("");
		
		userManager.addUser(user);
		
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
