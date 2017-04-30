package model;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@Local
public class PositionEJB {
	
	@PersistenceContext(unitName="rec_unit")
	EntityManager manager;

	public List<Position> findPositions() {
		TypedQuery<Position> query = manager.createNamedQuery("Position.findAll", Position.class);
		return query.getResultList();
	}

	public Position addNewEmployee(Position position) {
		manager.persist(position);
		return position;
	}
}
