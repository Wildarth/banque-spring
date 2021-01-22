package fr.exercice.banque.models;

public class Compte {

	private double solde;
	private int numero;

	public Compte() {
	}

	public Compte(double solde, int numero) {
		super();
		this.solde = solde;
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void ajouter(double montant) {
		solde += montant;
	}

	public void retirer(double montant) {
		solde -= montant;
	}

	@Override
	public String toString() {
		return "Compte [solde=" + solde + ", numero=" + numero + "]";
	}

}
