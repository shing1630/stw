package main.java.com.stw.constant;

import java.io.Serializable;
import java.util.Locale;

public class GConstant implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String SORT_FIELD_ID = "id.";

	public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

	public static final String YES = "Y";
	public static final String NO = "N";

	public static final String ERROR = "E";
	public static final String INFO = "I";
	public static final String FATAL = "F";
	public static final String WARN = "W";

	public static final String ALL = "all";

	public static final String EMPTY_VALUE = " ";

	public static final Locale DATE_LOCALE = Locale.US;
	public static final String DATE_LOCALE_STRING = "US";

	public static final String ATTR_STWSSESSION = "stwSession";
	public static final String VIEW_INDEX_PAGE = "/index.jsp";

	public static final String ACTION_SHOW_LOGIN = "showLogin";
	public static final String ACTION_SHOW_MAIN_PAGE = "showMainPage";

	// Date/ Datetime FORMAT
	public static final String INPUT_MASK_DATE = "99/99/9999";
	public static final String DATE_PATTERN = "dd/MM/yyyy";
	public static final String DTTM_PATTERN = "dd/MM/yyyy HH:mm";
	public static final String TIME_PATTERN = "HH:mm";
	public static final String DATE_TIMEZONE = "GMT+8";

	// NUMBER FORMAT
	public static final String FORMAT_WEIGHT = "#,##0.000";

}
