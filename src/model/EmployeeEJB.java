package model;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@Local
public class EmployeeEJB {
	
	@PersistenceContext(unitName="rec_unit")
	EntityManager manager;

	public List<Employee> findEmployees() {
		TypedQuery<Employee> query = manager.createNamedQuery("Employee.findAll", Employee.class);
		return query.getResultList();
	}

	public Employee addNewEmployee(Employee employee) {
		manager.persist(employee);
		return employee;
	}
}
