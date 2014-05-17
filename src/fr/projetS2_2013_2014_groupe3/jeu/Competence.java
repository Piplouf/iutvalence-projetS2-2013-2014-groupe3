package fr.projetS2_2013_2014_groupe3.jeu;


public abstract class Competence {
	
	private String nom;
	
	private int puissance;
	
	public Competence(String nom, int puissance){
		this.nom = nom;
		this.puissance = puissance;
	}
	
	public abstract void utiliserCompetence(Personnage cible);
	
	public int obtenirPuissance(){
		return this.puissance;
	}
	
	public String toString(){
		return( this.nom);
	}

}
