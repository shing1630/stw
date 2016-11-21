package main.java.com.stw.lib.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import main.java.com.stw.constant.GConstant;
import main.java.com.stw.lib.util.UrlFilter;


public class AccessControlManager implements Serializable, PhaseListener {
	private static final long serialVersionUID = 1L;

	private final HashMap<AccessLevel, List<UrlFilter>> levelFilters = new HashMap<AccessLevel, List<UrlFilter>>();

	public AccessControlManager() {
		this.initLevels();
		this.requires(AccessLevel.LOGGED).include("*")
				.exclude(GConstant.VIEW_INDEX_PAGE);
//				.exclude(GConstant.VIEW_LOGIN_PAGE);
	}

	public enum AccessLevel {
		NONE, LOGGED;
	}

	private void initLevels() {
		AccessLevel[] levels = AccessLevel.values();
		for (int i = 1; i < levels.length; i++) {
			this.levelFilters.put(levels[i], new ArrayList<UrlFilter>());
		}
	}

	private UrlFilter requires(AccessLevel level) {
		if (level == AccessLevel.NONE) {
			return null;
		}
		UrlFilter filter = new UrlFilter();
		List<UrlFilter> list = this.levelFilters.get(level);
		list.add(filter);
		return filter;
	}

	private AccessLevel requiredLevel(String viewId) {
		AccessLevel[] levels = AccessLevel.values();
		for (int i = levels.length - 1; i > 0; i--) {
			if (checkLevel(levels[i], viewId)) {
				return levels[i];
			}
		}
		return AccessLevel.NONE;
	}

	private boolean checkLevel(AccessLevel level, String viewId) {
		return this.matchUri(levelFilters.get(level), viewId);
	}

	private boolean matchUri(List<UrlFilter> list, String uri) {
		for (UrlFilter filter : list) {
			if (filter.matches(uri)) {
				return true;
			}
		}
		return false;
	}

//	private boolean isValidLoginSession(HttpSession session) {
//		boolean validLoginSession = false;
//
//		StwSession stwSession = (StwSession) session.getAttribute(GConstant.ATTR_MFMTSSESSION);
//		
//		if(stwSession==null){
//			session.setAttribute(GConstant.ATTR_MFMTSSESSION, new StwSession());
//		}else{
//			String sessionId = StdTool.getSessionId(session.getId());
//			if(sessionId.equals(stwSession.getSessionId())){
//				validLoginSession = true;
//			}
//		}
//
//		return validLoginSession;
//	}
//
//	private void redirectLoginRedirectPage(FacesContext context) {
//		context.getApplication().getNavigationHandler()
//				.handleNavigation(context, null, GConstant.ACTION_SHOW_REDIRECT_LOGIN);
//	}
//
//	private void redirectLoginPage(FacesContext context) {
//		context.addMessage(null, SystemMessage.getMessage(MessageCode.SESSION_EXPIRED));
//		context.getApplication().getNavigationHandler()
//				.handleNavigation(context, null, GConstant.ACTION_SHOW_LOGIN);
//		StdTool.showMsgDialog();
//	}
//
//	private void redirectChgPasswordPage(FacesContext context) {
//		context.addMessage(null, SystemMessage.getMessage(MessageCode.PASSWORD_EXPIRED));
//		context.getApplication().getNavigationHandler()
//				.handleNavigation(context, null, GConstant.ACTION_SHOW_CHG_PASSWD);
//		StdTool.showMsgDialog();
//	}
//
//	private void redirectMainMenu(FacesContext context) {
//		context.getApplication().getNavigationHandler()
//				.handleNavigation(context, null, GConstant.ACTION_SHOW_MAIN_MENU);
//		
//	}
//	
//	@Override
//	public void afterPhase(PhaseEvent event) {
//		try {
//			FacesContext context = event.getFacesContext();
//			HttpSession session = (HttpSession) context.getExternalContext()
//					.getSession(true);
//			StwSession stwSession = (StwSession) session
//					.getAttribute(GConstant.ATTR_MFMTSSESSION);
//			if (stwSession == null) {
//				stwSession = new StwSession();
//				session.setAttribute(GConstant.ATTR_MFMTSSESSION, stwSession);
//				this.redirectLoginRedirectPage(context);
//				
//				return;
//			}
//
//			String viewId = context.getViewRoot().getViewId();
//			if (GConstant.VIEW_LOGIN_PAGE.equals(viewId)) {
//				if (stwSession.isChgPasswd()) {
//					this.redirectChgPasswordPage(context);
//				} else if (stwSession.isLogged()) {
//					this.redirectMainMenu(context);
//				}
//
//				return;
//			}
//
//			AccessLevel required = requiredLevel(viewId);
//			switch (required) {
//			case NONE:
//				break;
//			case LOGGED:
//				if (!stwSession.isLogged()) {
//					this.redirectLoginPage(context);
//					break;
//				} else {
//					if (!this.isValidLoginSession(session)) {
//						this.redirectLoginPage(context);
//						break;
//					} else if (stwSession.isChgPasswd()) {
//						if (GConstant.VIEW_CHG_PASSWD_PAGE.equals(viewId)) {
//							return;
//						}
//						this.redirectChgPasswordPage(context);
//						break;
//					} else if (GConstant.VIEW_MAIN_PAGE.equals(viewId)) {
//						return;
//					} else if (!stwSession.isFnctAuthorized(viewId)) {
//						context.addMessage(null, SystemMessage.getMessage(MessageCode.NO_ACCESS_RIGHT));
//						StdTool.showMsgDialog();
//						this.redirectMainMenu(context);
//						break;
//					}
//					break;
//				}
//			default:
//				break;
//			}
//		} catch (Exception _ex) {
//			_ex.printStackTrace();
//		}
//	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
