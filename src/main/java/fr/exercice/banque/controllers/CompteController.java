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

import fr.exercice.banque.models.Compte;
import fr.exercice.banque.models.CompteRemunere;

@RestController
@RequestMapping("comptes")
public class CompteController {
	
	private List<Compte> comptes = initCompte();

	@GetMapping()
	public List<Compte> findAll(){
		return this.comptes;
	}
	
	@GetMapping("/{id}")
	public  Compte findById(@PathVariable int id) {
		return this.comptes.get(id);
	}
	
	@PostMapping
	public Compte create(@RequestBody Compte compte) {
		this.comptes.add(compte);
		return compte;
	}
	
	@PutMapping("/{id}")
	public Compte update(@PathVariable int id, @RequestBody Compte compte) {
		Compte newCompte = findById(id);
		newCompte.setSolde(compte.getSolde());
		newCompte.setNumero(compte.getNumero());
		return newCompte;
	}
	
	@DeleteMapping("/{id}")
	public Compte delete(@PathVariable int id) {
		return comptes.remove(id);
	}
	
	@GetMapping("/{id}/interet")
	public void verserInteret(@PathVariable int id) {
		((CompteRemunere) this.findById(id)).verserInteret();
	}
	
	@GetMapping("/interet")
	public void verserInteretAll() {
		for (Compte compte : comptes) {
			if(compte.getClass() == CompteRemunere.class)
				((CompteRemunere) compte).verserInteret();
		}
	}
	
	public List<Compte> initCompte(){
		List<Compte> compte = new ArrayList<>();
		
		compte.add(new Compte(5000, 66));
		compte.add(new Compte(600, 24));
		compte.add(new Compte(8400, 74));
		
		compte.add(new CompteRemunere(8400.0, 74, 0.5));
		
		return compte;
	}
	
}
