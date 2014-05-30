package fr.projetS2_2013_2014_groupe3.jeu;


/** Objet */
public abstract class Objet {

	private String nom;
	
	private TypeObjet type;
	
	/** Super constructeur des objets */
	public Objet(String nom, TypeObjet type){
		this.nom = nom;
		this.type = type;
	}
	
	/** Méthode à redefinir pour chaque classe héritant d'objet qui définiront leurs utilisations */
	public abstract String utiliserObjet(Personnage perso);

	public String getNom() {
		return this.nom;
	}
	
	public TypeObjet getTypeObjet(){
		return this.type;
	}
}
