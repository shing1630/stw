package main.java.com.stw.controller;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "langController", eager = true)
@SessionScoped
public class LangController implements Serializable {

	@PostConstruct
	public void init() {
		this.locale = Locale.TRADITIONAL_CHINESE.toString();
	}

	private static final long serialVersionUID = 1L;
	private String locale;

	private static Map<String, Object> countries;

	static {
		countries = new LinkedHashMap<String, Object>();
		countries.put("Ác", Locale.TRADITIONAL_CHINESE);
		countries.put("English", Locale.ENGLISH);
	}

	public Map<String, Object> getCountries() {
		return countries;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	// value change event listener
	public void localeChanged() {
		String newLocaleValue = this.getLocale();
		for (Map.Entry<String, Object> entry : countries.entrySet()) {
			if (entry.getValue().toString().equals(newLocaleValue)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
			}
		}
	}
}