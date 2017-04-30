package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Objects;
import java.util.Set;


/**
 * The persistent class for the positions database table.
 * 
 */
@Entity
@Table(name="positions")
@NamedQuery(name="Position.findAll", query="SELECT p FROM Position p")
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_position")
	private int idPosition;

	private String name;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="positionBean")
	private Set<Employee> employees;

	public Position() {
	}

	public int getIdPosition() {
		return this.idPosition;
	}

	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setPositionBean(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setPositionBean(null);

		return employee;
	}

	@Override
	public boolean equals(Object obj) {
		// Basic checks.
        if (obj == this) return true;
        if (!(obj instanceof Position)) return false;

        // Property checks.
        Position other = (Position) obj;
        return Objects.equals(idPosition, other.idPosition)
            && Objects.equals(name, other.name);
	}

}