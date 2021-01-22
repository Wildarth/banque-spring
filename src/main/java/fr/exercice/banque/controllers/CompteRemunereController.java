package fr.exercice.banque.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.exercice.banque.models.CompteRemunere;

//@RestController
//@RequestMapping("comptesRemuneres")
public class CompteRemunereController extends CompteController{
	
	@GetMapping("/{id}/interet")
	public void verserInteret(@PathVariable int id) {
		((CompteRemunere) super.findById(id)).verserInteret();
	}
}
