package main.java.com.stw.controller.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import main.java.com.stw.jpa.CUser;

public class CTF0002Form implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<CUser> userList = new ArrayList<CUser>();
	private CUser selectedUser = new CUser();

	public CTF0002Form() {

	}

	public List<CUser> getUserList() {
		return userList;
	}

	public void setUserList(List<CUser> userList) {
		this.userList = userList;
	}

	public CUser getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(CUser selectedUser) {
		this.selectedUser = selectedUser;
	}

	public void resetSelectedUser() {
		this.selectedUser = new CUser();
	}

	public void resetUserList() {
		this.setUserList(new ArrayList<CUser>());
	}

	public void resetCtf0002Form() {
		this.resetSelectedUser();
		this.resetUserList();
	}

	@Override
	public String toString() {
		return "CTF0002Form [userList=" + userList + ", selectedUser=" + selectedUser + "]";
	}
	
	

}
