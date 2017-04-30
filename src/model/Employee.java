package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_employee")
	private int idEmployee;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_visit", insertable = false, updatable = false)
	private Date lastVisit;

	private String login;

	private String name;

	private String password;

	//bi-directional many-to-one association to Check
	@OneToMany(mappedBy="employee")
	private Set<Check> checks;

	//bi-directional many-to-one association to Position
	@ManyToOne
	@JoinColumn(name="position")
	private Position positionBean;

	public Employee() {
	}

	public int getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public Date getLastVisit() {
		return this.lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Check> getChecks() {
		return this.checks;
	}

	public void setChecks(Set<Check> checks) {
		this.checks = checks;
	}

	public Check addCheck(Check check) {
		getChecks().add(check);
		check.setEmployee(this);

		return check;
	}

	public Check removeCheck(Check check) {
		getChecks().remove(check);
		check.setEmployee(null);

		return check;
	}

	public Position getPositionBean() {
		return this.positionBean;
	}

	public void setPositionBean(Position positionBean) {
		this.positionBean = positionBean;
	}
	
	@Override
	public boolean equals(Object obj) {
		// Basic checks.
        if (obj == this) return true;
        if (!(obj instanceof Employee)) return false;

        // Property checks.
        Employee other = (Employee) obj;
        return Objects.equals(idEmployee, other.idEmployee)
            && Objects.equals(name, other.name)
            && Objects.equals(lastVisit, other.lastVisit)
            && Objects.equals(password, other.password)
            && Objects.equals(login, other.login);
	}

}