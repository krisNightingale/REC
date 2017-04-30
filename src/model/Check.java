package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the checks database table.
 * 
 */
@Entity
@Table(name="checks")
@NamedQuery(name="Check.findAll", query="SELECT c FROM Check c")
public class Check implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_check")
	private int idCheck;

	private int discount;

	private float price;

	@Column(name="time", insertable = false, updatable = false)
	private Timestamp time;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	//bi-directional many-to-many association to Menu
	@ManyToMany
	@JoinTable(name="menu_checks",
	joinColumns = @JoinColumn(name="id_check", referencedColumnName="id_check"),
	inverseJoinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "id_menu"))
//	@JoinColumn(name="id_check")
	private Set<Menu> menus;

	public Check() {
	}

	public int getIdCheck() {
		return this.idCheck;
	}

	public void setIdCheck(int idCheck) {
		this.idCheck = idCheck;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

}