package model;

import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "birthdayConverter")
public class BirthdayConverter extends DateTimeConverter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component, String dateString) {
		System.out.println("getAsObject(): " + dateString);
		Object result;
		try {
			result = super.getAsObject(arg0, component, dateString);
			if (result instanceof Date) {
				// make it a Timestamp, because that is what jBPM will make of
				// it anyway
				result = new java.sql.Timestamp(((Date) result).getTime());
			}
		} catch (ConverterException ex) {
			return null;
		}
		return result;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent component, Object dateObject) {
		System.out.println("getAsString(): "
				+ (dateObject == null ? null : (dateObject.getClass().getSimpleName() + " " + dateObject.toString())));
		String result = null;
		try {
			result = super.getAsString(arg0, component, dateObject);
		} catch (ConverterException ex) {
			return null;
		}
		return result;
	}
}