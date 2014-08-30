package model;

public class User {
	private String userid;
	private String name;
	private String password;
	private int department;
	private int job;
	private String mphone;
	private String phone;
	private String email;
	private String signature;
	private String headpotrait;
	
	public String getHeadpotrait(){
		return headpotrait;
	}
	public String getSignature(){
		return signature;
	}
	public String getId(){
		return userid;
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
		this.userid = id;
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
	public void setSignature(String signature){
		this.signature = signature;
	}
	public void setHeadpotrait(String headpotrait){
		this.headpotrait = headpotrait;
	}
	
}
