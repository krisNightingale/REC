package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_check")
	private int idCheck;

	private byte discount;

	private float price;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false)
	private Date time;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	@ManyToMany
	@JoinTable(name = "menu_checks",
	joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "id_check"),
	inverseJoinColumns = @JoinColumn(name = "id_check", referencedColumnName = "id_menu"))
	private Set<Menu> menuItems;

	public Set<Menu> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Set<Menu> menuItems) {
		this.menuItems = menuItems;
	}

	public Check() {
	}

	public int getIdCheck() {
		return this.idCheck;
	}

	public void setIdCheck(int idCheck) {
		this.idCheck = idCheck;
	}

	public byte getDiscount() {
		return this.discount;
	}

	public void setDiscount(byte discount) {
		this.discount = discount;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
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
}