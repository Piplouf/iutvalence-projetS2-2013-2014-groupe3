package fr.projetS2_2013_2014_groupe3.jeu;


public abstract class Objet {

	private String nom;
	
	public Objet(String nom){
		this.nom = nom;
	}
	
	public abstract void utiliserObjet();
}
