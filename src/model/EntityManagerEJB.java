package model;

import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class EntityManagerEJB {
	
	@PersistenceContext(unitName="rec_unit")
	EntityManager em;	
	
	@Produces
    @RequestScoped
	public EntityManager getEm() {
		return em;
	}

	public Map<String, Object> getPropertiesEm() {
		return em.getProperties();
	}
	
	public boolean emContains(Object obj){
		return em.contains(obj);
	}
	
	public <T> T emFind(Class<T> entityClass, Object primaryKey){
		return em.find(entityClass, primaryKey);
	}
}
