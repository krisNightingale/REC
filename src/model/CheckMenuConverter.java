package model;

import java.util.HashSet;
import java.util.Set;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "check_menus_converter")
public class CheckMenuConverter implements Converter {

	static private Set<Menu> menuItems = new HashSet<>();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("-----MENU VALUE---- " + value);
		
		ValueExpression vex = context.getApplication().getExpressionFactory().createValueExpression(context.getELContext(), "#{controller}", MenuController.class);

        MenuController item = (MenuController)vex.getValue(context.getELContext());
        System.out.println("-----MENU found-----" + item.getOneMenuItem(Integer.valueOf(value)).getIdMenu());
        
        Menu menuItem = item.getOneMenuItem(Integer.valueOf(value));
        menuItems.add(menuItem);
        
        for (Menu menu : menuItems) {
			System.out.println("--- SET: " + menu.getIdMenu() + " " + menu.getName());
		}
        
		return menuItems;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		System.out.println("-----ID MENU---- " + obj.toString());
		return obj.toString();
	}

}
