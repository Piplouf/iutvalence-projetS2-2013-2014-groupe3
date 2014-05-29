package fr.projetS2_2013_2014_groupe3.objets;

import fr.projetS2_2013_2014_groupe3.jeu.Objet;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.TypeObjet;


public class PotionDeSoin extends Objet {
	
	private int quantiteSoin;
	
	public PotionDeSoin(int quantite){
		super ("Potion de soin", TypeObjet.DEFENSIF);
		this.quantiteSoin = quantite;
	}
	
	public String utiliserObjet(Personnage perso){
		perso.rajouterVie(this.quantiteSoin);
		return "";
	}
	
	public int obtenirQuantité(){
		return this.quantiteSoin;
	}
}

