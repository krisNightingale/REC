package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;


/**
 * The persistent class for the clients database table.
 * 
 */
@Entity
@Table(name="clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_client")
	private int idClient;

	private Timestamp birthday;

	private int bonuses;

	private String login;

	private String name;

	private String password;

	@Column(name="registration_time", insertable = false, updatable = false)
	private Timestamp registrationTime;

	private String telephone;

	//bi-directional many-to-one association to Check
	@OneToMany(mappedBy="client")
	private Set<Check> checks;

	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public int getBonuses() {
		return this.bonuses;
	}

	public void setBonuses(int bonuses) {
		this.bonuses = bonuses;
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

	public Timestamp getRegistrationTime() {
		return this.registrationTime;
	}

	public void setRegistrationTime(Timestamp registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Check> getChecks() {
		return this.checks;
	}

	public void setChecks(Set<Check> checks) {
		this.checks = checks;
	}

	public Check addCheck(Check check) {
		getChecks().add(check);
		check.setClient(this);

		return check;
	}

	public Check removeCheck(Check check) {
		getChecks().remove(check);
		check.setClient(null);

		return check;
	}

	@Override
	public boolean equals(Object obj) {
		// Basic checks.
        if (obj == this) return true;
        if (!(obj instanceof Client)) return false;

        // Property checks.
        Client other = (Client) obj;
        return Objects.equals(idClient, other.idClient)
            && Objects.equals(name, other.name)
            && Objects.equals(birthday, other.birthday)
            && Objects.equals(password, other.password)
            && Objects.equals(login, other.login)
            && Objects.equals(telephone, other.telephone);
	}
}