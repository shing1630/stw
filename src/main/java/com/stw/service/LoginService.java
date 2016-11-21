package main.java.com.stw.service;


import main.java.com.stw.jpa.CUser;

public interface LoginService {

	public CUser getLoginUser(String idCode);

}
