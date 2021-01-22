package fr.exercice.banque.models;

public class CompteRemunere extends Compte {
	
	private double taux;

	public CompteRemunere(Double solde, int numero, double taux) {
		super(solde,numero);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	public double calculerInteret() {
		return this.taux * super.getSolde();
	}
	
	public void verserInteret() {
		super.ajouter(this.calculerInteret());
	}

	@Override
	public String toString() {
		return super.toString() + "CompteRemunere [taux=" + taux + "]";
	}
	
	
}
