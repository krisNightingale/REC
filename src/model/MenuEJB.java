package model;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@Local
public class MenuEJB {

	@PersistenceContext(unitName="rec_unit")
	EntityManager manager;

	public List<Menu> findMenuItems() {
		TypedQuery<Menu> query = manager.createNamedQuery("Menu.findAll", Menu.class);
		return query.getResultList();
	}

	public Menu addNewMenuItem(Menu menu) {
		manager.persist(menu);
		return menu;
	}

}
