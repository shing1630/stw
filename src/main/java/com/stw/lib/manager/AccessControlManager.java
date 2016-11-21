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
