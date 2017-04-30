package model;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

@FacesConverter("entityConverter")
@RequestScoped
public class EntityConverter implements Converter {

//	@PersistenceContext(unitName="rec_unit")
//	private EntityManager entityManager;
	
	@EJB
	private EntityManagerEJB eManager;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			System.out.println("\n -----OBJECT---   " + value + "\n");
			String[] split = value.split("@");
			System.out.println("\n -----OBJECT---   " + split[0]+"  "+ split[1] + "\n");
			
			for (Map.Entry<String, Object> entry : eManager.getPropertiesEm().entrySet()) {
				System.out.println("\n -----EM-----   " + entry.getKey() + "/" + entry.getValue());
			}
			System.out.println("\n -----OBJECT---   " + split[0]+"  "+ split[1] + "\n");
			System.out.println("\n -----OBJECT---   " + eManager.emFind(Class.forName(split[0]), Long.valueOf(split[1])).toString() + "\n");
			return eManager.emFind(Class.forName(split[0]), Long.valueOf(split[1]));
		} catch (NumberFormatException | ClassNotFoundException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		System.out.println("\n -----OBJECT111---   " + object.toString() + "\n");
		System.out.println("\n -----EM111-------   " + eManager.emContains(object) + "\n");
//		try {
//			Class<? extends Object> myClass = object.getClass();
//			for (Field f : myClass.getDeclaredFields()) {
//				if (f.isAnnotationPresent(Id.class)) {
//					f.setAccessible(true);
//					Integer id = (Integer) f.get(object);
//					return myClass.getCanonicalName() + "@" + id.toString();
//				}
//			}
//		} catch (IllegalArgumentException | IllegalAccessException e) {
//		}
		return object.toString();
	}
}
