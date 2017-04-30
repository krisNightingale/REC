package model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.WeakHashMap;

@FacesConverter(value = "entityConverter2")
public class EntityConverter2 implements Converter {

	private static Map<Object, String> entities = new WeakHashMap<Object, String>();

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object entity) {
		System.out.println("\n -----EM-----   ");
		for (Map.Entry<Object, String> entry : entities.entrySet()) {
			System.out.println("\n -----EM-----   " + entry.getKey() + " / " + entry.getValue());
		}
		synchronized (entities) {
			if (!entities.containsKey(entity)) {
				String uuid = UUID.randomUUID().toString();
				entities.put(entity, uuid);
				return uuid;
			} else {
				return entities.get(entity);
			}
		}
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String uuid) {
		for (Entry<Object, String> entry : entities.entrySet()) {
			if (entry.getValue().equals(uuid)) {
				System.out.println("\n -----EM-----   " + entry.getKey());
				return entry.getKey();
			}
		}
		return null;
	}

}