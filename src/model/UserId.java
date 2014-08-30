package model;

public class UserId {
	private String id;
	private String name;
	private boolean state;
	
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public boolean getState(){
		return state;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setState(boolean state){
		this.state = state;
	}
}
