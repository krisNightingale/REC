package model;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@Local
public class CheckEJB {

	@PersistenceContext(unitName="rec_unit")
	EntityManager manager;

	public List<Check> findChecks() {
		TypedQuery<Check> query = manager.createNamedQuery("Check.findAll", Check.class);
		return query.getResultList();
	}

	public Check addNewCheck(Check check) {
		manager.persist(check);
		return check;
	}

}
