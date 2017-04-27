package model;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@Local
public class ClientEJB {

	@PersistenceContext(unitName="rec_unit")
	EntityManager manager;

	public List<Client> findClients() {
		TypedQuery<Client> query = manager.createNamedQuery("Client.findAll", Client.class);
		return query.getResultList();
	}

	public Client addNewClient(Client client) {
		manager.persist(client);
		return client;
	}

}
