package main.java.com.stw.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_user database table.
 * 
 */
@Entity
@Table(name="c_user")
@NamedQuery(name="CUser.findAll", query="SELECT c FROM CUser c")
public class CUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CODE")
	private String idCode;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="PW_CODE")
	private String pwCode;

	@Column(name="TEL_NO")
	private int telNo;

	public CUser() {
	}

	public String getIdCode() {
		return this.idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPwCode() {
		return this.pwCode;
	}

	public void setPwCode(String pwCode) {
		this.pwCode = pwCode;
	}

	public int getTelNo() {
		return this.telNo;
	}

	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}
	
	public void reset() {
		this.setFirstName(null);
		this.setIdCode(null);
		this.setLastName(null);
		this.setPwCode(null);
		this.setTelNo(0);
	}

}