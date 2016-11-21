package main.java.com.stw.controller;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import main.java.com.stw.constant.GConstant;
import main.java.com.stw.controller.form.LoginForm;
import main.java.com.stw.jpa.CUser;
import main.java.com.stw.lib.manager.StwSession;
import main.java.com.stw.service.LoginService;

@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{loginService}")
	private transient LoginService loginService;

	@ManagedProperty("#{stwSession}")
	protected StwSession stwSession;

	private LoginForm loginForm = new LoginForm();

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public StwSession getStwSession() {
		return stwSession;
	}

	public void setStwSession(StwSession stwSession) {
		this.stwSession = stwSession;
	}

	public LoginForm getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

	public String goLoginPage() {
		stwSession.reset();
		return GConstant.ACTION_SHOW_LOGIN;
	}

	public String processLogin() {

		String action = null;
		FacesContext ctx = FacesContext.getCurrentInstance();

		if (stwSession != null) {

			System.out.println("stwSession != null");

			if (stwSession.isLogged()) {
				System.out.println("stwSession isLogged");
				return GConstant.ACTION_SHOW_MAIN_PAGE;
			}
		}

		String idCode = loginForm.getLoginUser().getIdCode();
		String pwCode = loginForm.getLoginUser().getPwCode();

		CUser resultUser = loginService.getLoginUser(idCode);

		if (resultUser == null) {

			System.out.println("resultUser == null");

			Locale locale = ctx.getViewRoot().getLocale();
			ResourceBundle rb = ResourceBundle.getBundle("main.java.com.stw.resource.label", locale);
			String errorMsg = rb.getString("sys.msg.error");
			String msgDesc = rb.getString("sys.msg.id_pw_incorrect");

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMsg, msgDesc));

		} else {
			if (pwCode.equals(resultUser.getPwCode())) {
				action = GConstant.ACTION_SHOW_MAIN_PAGE;
				stwSession.setLoginStatus(StwSession.STATUS_LOGGED);
				stwSession.setUser(resultUser);
			} else {
				System.out.println("final else");
				Locale locale = ctx.getViewRoot().getLocale();
				ResourceBundle rb = ResourceBundle.getBundle("main.java.com.stw.resource.label", locale);
				String errorMsg = rb.getString("sys.msg.error");
				String msgDesc = rb.getString("sys.msg.id_pw_incorrect");

				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMsg, msgDesc));
			}
		}

		return action;

	}

	/**
	 * Process Logout Action
	 */
	public String processLogout() {
		stwSession.reset();

		return GConstant.ACTION_SHOW_MAIN_PAGE;
	}

}
