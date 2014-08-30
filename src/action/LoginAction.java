package action;

import java.util.HashMap;
import java.util.Map;

import service.UserManager;

import model.User;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	
	private Map<String, Object> responseJson;
	private String id;
	private String password;
	
	public void setId(String id){
		this.id = id;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getId(){
		return id;
	}
	public String getPassword(){
		return password;
	}
	
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	
	public String execute() throws Exception{
		responseJson = new HashMap<String, Object>();
		
		UserManager userManager = new UserManager();
		
		User user = userManager.login(id, password);
		
		responseJson.put("login", new Gson().toJson(user, User.class));
		
		if(responseJson!=null){
			System.out.println(responseJson.toString());
			return SUCCESS;
		}
		else {
			responseJson.put("login", null);
		}
		return "fail";
		
	}
}
