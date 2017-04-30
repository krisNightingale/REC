package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "client_controller")
@RequestScoped
public class ClientController {

	@EJB
	private ClientEJB clientEJB;
	private Client client = new Client();
	private List<Client> list = new ArrayList<>();

	public List<Client> getClientList() {
		list = clientEJB.findClients();
		return list;
	}

	public String addNewClient() {
		client = clientEJB.addNewClient(client);
		list = clientEJB.findClients();
		return "client_list.xhtml";
	}

	public ClientEJB getClientEJB() {
		return clientEJB;
	}

	public void setClientEJB(ClientEJB clientEJB) {
		this.clientEJB = clientEJB;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getList() {
		return getClientList();
	}
	
	public void setList(List<Client> list) {
		this.list = list;
	}

	public Client getOneClient(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (Client client : getClientList()){
            if (id.equals(client.getIdClient())){
                return client;
            }
        }
        return null;
    }
	
}
