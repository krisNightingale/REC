package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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

	@Column(name="client_id")
	private int clientId;

	private int discount;

	@Column(name="employee_id")
	private int employeeId;

	private float price;

	@Column(name="time", insertable = false, updatable = false)
	private Timestamp time;

	public Check() {
	}

	public int getIdCheck() {
		return this.idCheck;
	}

	public void setIdCheck(int idCheck) {
		this.idCheck = idCheck;
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

}