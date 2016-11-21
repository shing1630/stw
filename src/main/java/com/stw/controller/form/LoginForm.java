package main.java.com.stw.controller.form;

import java.io.Serializable;

import main.java.com.stw.jpa.CUser;

public class LoginForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private CUser loginUser = new CUser();

	public LoginForm() {

	}

	public CUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(CUser loginUser) {
		this.loginUser = loginUser;
	}

	public void resetLoginUser() {
		this.setLoginUser(null);
	}

	public void resetloginForm() {
		this.resetLoginUser();

	}

	@Override
	public String toString() {
		return "LoginForm [loginUser=" + loginUser + "]";
	}

}
