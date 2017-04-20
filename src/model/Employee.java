package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.*;
import java.util.Date;
//import java.lang.System;


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

	private int position;

	public Employee() {
	}

	public int getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public Date getLastVisit() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		System.out.println(dateFormat.format(this.lastVisit));
		return this.lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
//		this.lastVisit = new Date(System.currentTimeMillis());
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

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}