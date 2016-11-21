package main.java.com.stw.service;

import java.util.List;

import main.java.com.stw.jpa.CUser;

public interface CTF0002Service {

	public List<CUser> getAllUserList();
	
	public void refresh(CUser c);
	
	public CUser find(Object id);
	
	public void createUser(CUser c);
	
	public void updateUser(CUser c);
}
