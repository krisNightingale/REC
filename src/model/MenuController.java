package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "controller")
@RequestScoped
public class MenuController {

	@EJB
	private MenuEJB menuEJB;
	private Menu menu = new Menu();
	private List<Menu> list = new ArrayList<>();

	public List<Menu> getMenuList() {
		list = menuEJB.findMenuItems();
		return list;
	}

	public String viewMenu() {
		return "menu_list.xhtml";
	}

	public String addNewMenuItem() {
		menu = menuEJB.addNewMenuItem(menu);
		list = menuEJB.findMenuItems();
		return "menu_list.xhtml";
	}

	public Menu getMenuItem() {
		return menu;
	}

	public MenuEJB getMenuEJB() {
		return menuEJB;
	}

	public void setMenuEJB(MenuEJB menuEJB) {
		this.menuEJB = menuEJB;
	}

	public void setMenuItem(Menu menu) {
		this.menu = menu;
	}

	public void setList(List<Menu> list) {
		this.list = list;
	}

	public List<Menu> getList() {
		return getMenuList();
	}
	
	public Menu getOneMenuItem(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (Menu item : getMenuList()){
            if (id.equals(item.getIdMenu())){
                return item;
            }
        }
        return null;
    }
}
