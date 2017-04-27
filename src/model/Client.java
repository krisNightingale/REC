package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_client")
	private int idClient;

	//bi-directional many-to-one association to Check
	@OneToMany(mappedBy="client")
	private List<Check> checks;

	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public List<Check> getChecks() {
		return this.checks;
	}

	public void setChecks(List<Check> checks) {
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

}