package main.java.com.stw.controller.form;

import java.io.Serializable;

import main.java.com.stw.jpa.CUser;

public class CTF0002FormDialog implements Serializable {
	private static final long serialVersionUID = 1L;

	private CUser dialogUser = new CUser();
	private boolean newUser;

	public CTF0002FormDialog() {

	}

	public CUser getDialogUser() {
		return dialogUser;
	}

	public void setDialogUser(CUser dialogUser) {
		this.dialogUser = dialogUser;
	}

	public void resetDialogUser() {
		this.dialogUser = new CUser();
		dialogUser.reset();
	}

	public void resetCtf0002FormDialog() {
		this.resetDialogUser();
	}

	public boolean isNewUser() {
		return newUser;
	}

	public boolean getNewUser() {
		return newUser;
	}

	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}

	@Override
	public String toString() {
		return "CTF0002FormDialog [dialogUser=" + dialogUser + ", newUser=" + newUser + "]";
	}

}
