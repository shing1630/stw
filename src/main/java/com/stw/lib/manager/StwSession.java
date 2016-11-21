package main.java.com.stw.lib.manager;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.com.stw.jpa.CUser;

@ManagedBean(name = "stwSession")
@SessionScoped
public final class StwSession implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final int STATUS_NONE = 0;
	public static final int STATUS_LOGGED = 1;
	public static final int STATUS_CHG_PASSWD = 2;

	private int loginStatus = StwSession.STATUS_NONE;
	private CUser user = null;
	private String ipAddress = null;
	private String sessionId = null;
	private Date sysDttm = null;

	public StwSession() {
	}

	public void reset() {
		this.setLoginStatus(StwSession.STATUS_NONE);
		this.setUser(null);
		this.setIpAddress(null);
		this.setSessionId(null);
	}

	public CUser getUser() {
		return user;
	}

	public void setUser(CUser user) {
		this.user = user;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getSysDttm() {
		Date sysDttm = new Date();
		this.sysDttm = sysDttm;
		return sysDttm;
	}

	public boolean isLogged() {
		return this.getLoginStatus() > StwSession.STATUS_NONE;
	}

	public boolean isChgPasswd() {
		return this.getLoginStatus() == StwSession.STATUS_CHG_PASSWD;
	}
	
	public void toMyAcc() {
		
	}
	

	@Override
	public String toString() {
		return "StwSession [loginStatus=" + loginStatus + ", user=" + user + ", ipAddress=" + ipAddress + ", sessionId="
				+ sessionId + ", sysDttm=" + sysDttm + "]";
	}

}
