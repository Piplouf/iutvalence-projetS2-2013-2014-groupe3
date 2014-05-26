package fr.projetS2_2013_2014_groupe3.jeu;


public abstract class Objet {

	private String nom;
	
	private TypeObjet type;
	
	public Objet(String nom, TypeObjet type){
		this.nom = nom;
		this.type = type;
	}
	
	public abstract String utiliserObjet(Personnage perso);

	public String getNom() {
		return this.nom;
	}
	
	public TypeObjet getTypeObjet(){
		return this.type;
	}
}
