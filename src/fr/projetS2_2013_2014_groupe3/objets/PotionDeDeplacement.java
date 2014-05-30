package fr.projetS2_2013_2014_groupe3.objets;

import fr.projetS2_2013_2014_groupe3.jeu.Objet;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.TypeObjet;

/** Objet rajoutant de la capacité de déplacement*/
public class PotionDeDeplacement extends Objet {

	private int nombreDeplacementAAjouter;
	
	public PotionDeDeplacement(int nombreDep) {
		super("Potion de déplacement", TypeObjet.DEFENSIF);
		this.nombreDeplacementAAjouter = nombreDep;
	}

	@Override
	/** Rajoute de la capacité de déplacement au personnage */
	public String utiliserObjet(Personnage perso) {
		perso.ajouterCapaciteDeDeplacement(this.nombreDeplacementAAjouter);
		return "";
	}

}
