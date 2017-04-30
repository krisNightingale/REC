package model;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@Local
public class CategoryEJB {
	
	@PersistenceContext(unitName="rec_unit")
	EntityManager manager;

	public List<Category> findCategories() {
		TypedQuery<Category> query = manager.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}

	public Category addNewCategory(Category category) {
		manager.persist(category);
		return category;
	}
}
