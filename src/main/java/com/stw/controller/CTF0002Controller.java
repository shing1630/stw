package main.java.com.stw.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import main.java.com.stw.controller.form.CTF0002Form;
import main.java.com.stw.controller.form.CTF0002FormDialog;
import main.java.com.stw.jpa.CUser;
import main.java.com.stw.service.CTF0002Service;

@ManagedBean(name = "ctf0002Controller")
@ViewScoped
public class CTF0002Controller implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FNCT_ID = "ctf0002";

	@ManagedProperty(value = "#{ctf0002Service}")
	private transient CTF0002Service ctf0002Service;

	private CTF0002Form ctf0002Form = new CTF0002Form();
	private CTF0002FormDialog ctf0002FormDialog = new CTF0002FormDialog();
	private List<CUser> userList = new ArrayList<>();

	public CTF0002Service getCtf0002Service() {
		return ctf0002Service;
	}

	public void setCtf0002Service(CTF0002Service ctf0002Service) {
		this.ctf0002Service = ctf0002Service;
	}

	public CTF0002Form getCtf0002Form() {
		return ctf0002Form;
	}

	public void setCtf0002Form(CTF0002Form ctf0002Form) {
		this.ctf0002Form = ctf0002Form;
	}

	public CTF0002FormDialog getCtf0002FormDialog() {
		return ctf0002FormDialog;
	}

	public void setCtf0002FormDialog(CTF0002FormDialog ctf0002FormDialog) {
		this.ctf0002FormDialog = ctf0002FormDialog;
	}

	@PostConstruct
	public void init() {

		try {

			System.out.println("init");

			this.ctf0002Form.resetCtf0002Form();

			this.ctf0002FormDialog.resetCtf0002FormDialog();

			this.ctf0002Form.setUserList((List<CUser>) this.ctf0002Service.getAllUserList());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void initAdd() {
		try {

			this.ctf0002FormDialog.resetCtf0002FormDialog();
			this.ctf0002FormDialog.setNewUser(true);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void initEdit() {
		try {

			RequestContext rc = RequestContext.getCurrentInstance();

			this.ctf0002FormDialog.resetCtf0002FormDialog();
			if (this.ctf0002Form.getSelectedUser() == null) {
				FacesContext ctx = FacesContext.getCurrentInstance();

				Locale locale = ctx.getViewRoot().getLocale();
				ResourceBundle rb = ResourceBundle.getBundle("main.java.com.stw.resource.label", locale);
				String errorMsg = rb.getString("sys.msg.error");
				String recordBeSelect = rb.getString("sys.msg.record_be_select");

				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMsg, recordBeSelect));

				return;

			}
			this.ctf0002FormDialog.setDialogUser(this.ctf0002Form.getSelectedUser());
			this.ctf0002FormDialog.setNewUser(false);

			rc.addCallbackParam("isShow", true);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void processSave() {
		try {

			System.out.println("-----------------processSave start");

			this.ctf0002Service.createUser(this.ctf0002FormDialog.getDialogUser());

			init();

			System.out.println("-----------------processSave end");

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void processEdit() {
		try {

			System.out.println("-----------------processEdit start");

			this.ctf0002Service.updateUser(this.ctf0002FormDialog.getDialogUser());

			init();

			System.out.println("-----------------processEdit end");

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
