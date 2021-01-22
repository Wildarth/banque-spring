package fr.exercice.banque.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.exercice.banque.models.Client;
import fr.exercice.banque.models.Compte;

@RestController
@RequestMapping("clients")
public class ClientController {
	
private List<Client> clients = initClient();
	
	@GetMapping()
	public List<Client> findAll(){
		return this.clients;
	}
	
	@GetMapping("/{id}")
	public  Client findById(@PathVariable int id) {
		return this.clients.get(id);
	}
	
	@PostMapping
	public Client create(@RequestBody Client client) {
		this.clients.add(client);
		return client;
	}
	
	@PutMapping("/{id}")
	public Client update(@PathVariable int id, @RequestBody Client client) {
		Client newClient = findById(id);
		newClient.setNom(client.getNom());
		newClient.setPrenom(client.getPrenom());
		newClient.setAge(client.getAge());
		newClient.setNumero(client.getNumero());
		return newClient;
	}
	
	@DeleteMapping("/{id}")
	public Client delete(@PathVariable int id) {
		return clients.remove(id);
	}
	
	@PutMapping("/{id}/compte")
	public void ajouterCompte(@PathVariable int id, @RequestBody Compte compte) {
		this.clients.get(id).ajouterCompte(compte);
	}
	
	@GetMapping("/{idClient}/compte/{idCompte}")
	public Compte getCompte(@PathVariable int idClient, @PathVariable int idCompte) {
		return findById(idClient).getCompte(idCompte);
	}

	@GetMapping("/{idClient}/compte")
	public List<Compte> findAllCompte(@PathVariable int idClient) {
		return findById(idClient).getComptes();
	}

	@PutMapping("/{idClient}/compte/{idCompte}")
	public void updateCompte(@PathVariable int idClient, @PathVariable int idCompte, @RequestBody Compte compte) {
		Compte newCompte = findById(idClient).getCompte(idCompte);
		newCompte.setSolde(compte.getSolde());
		newCompte.setNumero(compte.getNumero());
	}

	public List<Client> initClient(){
		List<Client> clients = new ArrayList<>();
		
		Client guillaume = new Client("Jovelin", "Guillaume", 23, 501);
		guillaume.ajouterCompte(new Compte(5000, 66));
		clients.add(guillaume);
		
		Client axel = new Client("Blanchard", "Axel", 24, 203);
		axel.ajouterCompte(new Compte(4999, 53));
		clients.add(axel);
		
		return clients;
	}
}
