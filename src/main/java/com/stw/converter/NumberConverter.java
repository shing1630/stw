package main.java.com.stw.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

@FacesConverter("numberConverter")
public class NumberConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext faceContext, UIComponent uiComponent, String inputValue)
			throws ConverterException {

	/*	if (!CommonUtils.isInteger(inputValue)) {

			inputValue = null;
		}*/

		return inputValue;
	}

	@Override
	public String getAsString(FacesContext faceContext, UIComponent uiComponent, Object inputObject) {
		if (inputObject == null) {
			return null;
		}

		String inputValue = (String) inputObject;

/*		if (StringUtils.isNotBlank(inputValue)) {
			if (!CommonUtils.isInteger(inputValue)) {
				inputValue = null;
			}
		}*/

		return inputValue;
	}
}
